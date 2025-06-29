package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {
    Addition a = new Addition();

    @Test
    void testAdd(){
        assertEquals(50 , a.add(30,20));
    }

}
