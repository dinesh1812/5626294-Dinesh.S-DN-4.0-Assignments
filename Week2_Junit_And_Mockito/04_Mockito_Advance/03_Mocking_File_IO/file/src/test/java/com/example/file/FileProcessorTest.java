package com.example.file;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class FileProcessorTest {

    @Test
    void testAppendLine() {
        // Create mock FileService
        FileService mockFileService = mock(FileService.class);

        // Stub read behavior
        String path = "test.txt";
        when(mockFileService.read(path)).thenReturn("Line1\nLine2");

        // Call service logic
        FileProcessor processor = new FileProcessor(mockFileService);
        processor.appendLine(path, "Line3");

        // Verify write was called with expected content
        verify(mockFileService).write(path, "Line1\nLine2\nLine3");
    }
}