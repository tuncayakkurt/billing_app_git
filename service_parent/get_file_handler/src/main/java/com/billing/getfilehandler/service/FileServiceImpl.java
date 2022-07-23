package com.billing.getfilehandler.service;

import com.billing.getfilehandler.parser.Document;
import com.blg.client.enums.FileTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.blg.client.constants.File.ARCHIVE_STORAGE_URL;
import static com.blg.client.constants.File.FILE_STORAGE_URL;
import static com.blg.client.constants.Topics.NORMALIZATION_READ_LINE_CHANNEL;

@Service
public class FileServiceImpl implements FileService {
    private final Path root = Paths.get(FILE_STORAGE_URL);
    private final Path archive = Paths.get(ARCHIVE_STORAGE_URL);
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public FileServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void fetchFileAndSendTopic() {
        List<Path> files = getAllFile();
        AtomicReference<Document> document = new AtomicReference<>();
        files.stream().forEach(file -> {
            try {
                document.set(Document.create(file.getFileName().toString()).orElseThrow(RuntimeException::new));
                sendLinesToTopic(document.get().parseToStringList(file));
                moveFileToArchiveThenDelete(file);
            } catch (Exception ex) {
                logger.error("fetchFileAndSendTopic -> " + ex.getMessage());
            }
        });

    }

    private void moveFileToArchiveThenDelete(Path file) {
        Path dest = createArchiveFolder();
        try {
            Files.copy(file, dest.resolve(root.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
            Files.delete(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Path createArchiveFolder() {
        String folderName = createFolderName();
        Path dest = archive.resolve(folderName);
        try {
            if (!Files.isDirectory(dest))
                return Files.createDirectory(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dest;
    }

    private String createFolderName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(LocalDateTime.now());
    }

    private void sendLinesToTopic(List<String> fileLines) {
        fileLines.stream().forEach(line -> kafkaTemplate.send(NORMALIZATION_READ_LINE_CHANNEL, line));
    }

    private List<Path> getAllFile() {
        try (Stream<Path> fileList = Files.list(root)) {
            return Arrays.stream(fileList.toArray(Path[]::new))
                    .filter(file -> FileTypes.isFileTypeExist(file.getFileName().toString()))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
