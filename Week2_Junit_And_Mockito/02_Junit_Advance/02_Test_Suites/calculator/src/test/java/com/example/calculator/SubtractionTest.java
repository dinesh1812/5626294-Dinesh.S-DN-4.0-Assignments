package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubtractionTest {
    Subtraction s = new Subtraction();

    @Test
    void testSubtract(){
        assertEquals(30, s.subtract(40,10));
    }
}
