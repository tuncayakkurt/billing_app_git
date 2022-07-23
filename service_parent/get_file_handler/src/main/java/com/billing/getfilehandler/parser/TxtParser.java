package com.billing.getfilehandler.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TxtParser implements Document {

    @Override
    public List<String> parseToStringList(Path file) throws IOException {
        BufferedReader buffReader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
        return fetchFileLines(buffReader);
    }

    private List<String> fetchFileLines(BufferedReader buffReader) throws IOException {
        List<String> fileLines = buffReader.lines().collect(Collectors.toList());
        return fileLines;
    }
}
