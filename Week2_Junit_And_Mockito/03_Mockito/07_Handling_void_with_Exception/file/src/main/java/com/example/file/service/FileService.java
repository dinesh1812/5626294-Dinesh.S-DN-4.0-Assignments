package com.example.file.service;

import com.example.file.model.File;

public class FileService {
    private File deleter;

    public FileService(File deleter) {
        this.deleter = deleter;
    }

    public void removeFile(String path) {
        deleter.deleteFile(path);
    }
}
