package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

/* Exercise 2: Writing Basic Junit Tests */

public class CalculatorTest {
    Calculator calc = new Calculator();

    // Addition - Positive Test case
    @Test
    public void testAddPositive(){
        int sum = calc.add(10, 20);
        assertEquals(30, sum);
    }

    // Addition - Negative Test case
    @Test
    public void testAddNegative(){
        int sum = calc.add(20, 20);
        assertNotEquals(20, sum);
    }

    // Subtraction
    @Test
    public void testSubtract(){
        int diff = calc.subtract(30, 20);
        assertEquals(10, diff);
    }

    // Multiplication
    @Test
    public void testProduct(){
        int product = calc.product(4, 5);
        assertEquals(20, product);
    }
}
