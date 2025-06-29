package com.example.demo;

public class PerformanceTester {

    public void performTask() {
        try {
            // Simulate a task that takes 400 milliseconds
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}