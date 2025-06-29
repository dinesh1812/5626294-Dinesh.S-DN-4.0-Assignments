package com.example.file;

public interface FileService {
    String read(String path);
    void write(String path, String content);
}
