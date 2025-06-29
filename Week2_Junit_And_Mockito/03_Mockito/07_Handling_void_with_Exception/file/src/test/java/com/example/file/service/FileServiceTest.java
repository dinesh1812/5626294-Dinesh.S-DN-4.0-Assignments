package com.example.file.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.file.model.File;

@ExtendWith(MockitoExtension.class)
public class FileServiceTest {

    @Mock
    private File fileDeleter;

    @InjectMocks
    private FileService fileService;

    @Test
    public void testDeleteFileThrowsException() {
        doThrow(new RuntimeException("File not found"))
            .when(fileDeleter).deleteFile("abc.txt");

        assertThrows(RuntimeException.class, () -> {
            fileService.removeFile("abc.txt");
        });

        verify(fileDeleter).deleteFile("abc.txt");
    }
}
