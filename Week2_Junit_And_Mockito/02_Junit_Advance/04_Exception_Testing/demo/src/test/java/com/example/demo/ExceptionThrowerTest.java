package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testThrowsExceptionForNullInput() {
        assertThrows(IllegalArgumentException.class, () -> thrower.throwException(null));
    }

    @Test
    void testThrowsExceptionForBlankInput() {
        assertThrows(IllegalArgumentException.class, () -> thrower.throwException("   "));
    }

    @Test
    void testNoExceptionForValidInput() {
        assertDoesNotThrow(() -> thrower.throwException("Hello"));
    }
}