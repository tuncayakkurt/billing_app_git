package com.billing.getfilehandler.parser;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface Document {
    List<String> parseToStringList(Path file) throws IOException;

    static Optional<Document> create(String filename) {
        String fileExtension = StringUtils.getFilenameExtension(filename);
        return switch (fileExtension) {
            case "txt" -> Optional.of(new TxtParser());
            default -> Optional.of(null);
        };
    }
}
