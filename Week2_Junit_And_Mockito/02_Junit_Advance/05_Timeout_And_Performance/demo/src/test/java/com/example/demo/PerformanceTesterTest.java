package com.example.demo;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTaskCompletesInTime() {
        assertTimeout(Duration.ofMillis(500), () -> tester.performTask());
    }

    // @Test
    // void testFailsIfExceedsTime() {
    //     assertTimeout(Duration.ofMillis(100), () -> {
    //         // Intentional Test Fail
    //         Thread.sleep(200);
    //     });
    // }
}
