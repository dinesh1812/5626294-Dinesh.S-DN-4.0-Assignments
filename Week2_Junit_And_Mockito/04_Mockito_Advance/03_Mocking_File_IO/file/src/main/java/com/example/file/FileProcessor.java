package com.example.file;

public class FileProcessor {
    private final FileService fileService;

    public FileProcessor(FileService fileService) {
        this.fileService = fileService;
    }

    public void appendLine(String path, String newLine) {
        String content = fileService.read(path);
        content += "\n" + newLine;
        fileService.write(path, content);
    }
}