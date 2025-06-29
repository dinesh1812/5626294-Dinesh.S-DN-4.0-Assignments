package com.example.demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataProcessorTest {

    static DataProcessor processor;

    @BeforeAll
    static void setup() {
        processor = new DataProcessor();
    }

    @Test
    @Order(1)
    void testInitializeData() {
        processor.initializeData();
        List<String> data = processor.getData();
        assertEquals(2, data.size());
        assertEquals("apple", data.get(0));
    }

    @Test
    @Order(2)
    void testProcessData() {
        List<String> result = processor.processData();
        assertEquals(List.of("APPLE", "BANANA"), result);
    }

    @Test
    @Order(3)
    void testClearData() {
        processor.clearData();
        assertTrue(processor.getData().isEmpty());
    }
}

