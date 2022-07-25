package com.billing.filetransferhandler.service.impl;

import com.billing.filetransferhandler.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static com.blg.client.constants.File.FILE_STORAGE_URL;
import static com.blg.client.constants.Topics.NORMALIZATION_READ_LINE_CHANNEL;

@Service
public class FilesStorageServiceImpl implements FileStorageService {
    private final Path root = Paths.get(FILE_STORAGE_URL);
    private KafkaTemplate kafkaTemplate;

    @Autowired
    public void FileServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String save(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(line);
                //send topic
                kafkaTemplate.send(NORMALIZATION_READ_LINE_CHANNEL, line);
            }
            return "";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        public String save_orig(MultipartFile file) {
        String uniqueName = createUniqueFilename(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), this.root.resolve(uniqueName));
            return uniqueName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createUniqueFilename(String filename) {
        String prefix = LocalDateTime.now().toString();
        return String.format("%s_%s", prefix, filename);
    }
}
