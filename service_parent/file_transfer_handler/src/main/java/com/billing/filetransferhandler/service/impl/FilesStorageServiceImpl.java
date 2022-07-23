package com.billing.filetransferhandler.service.impl;

import com.billing.filetransferhandler.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static com.blg.client.constants.File.FILE_STORAGE_URL;

@Service
public class FilesStorageServiceImpl implements FileStorageService {
    private final Path root = Paths.get(FILE_STORAGE_URL);

    @Override
    public String save(MultipartFile file) {
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
