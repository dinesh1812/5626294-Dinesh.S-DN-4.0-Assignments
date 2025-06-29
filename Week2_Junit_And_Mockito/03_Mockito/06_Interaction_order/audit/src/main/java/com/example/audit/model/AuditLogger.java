package com.example.audit.model;

public interface AuditLogger {
    void startLog();
    void writeLog(String message);
    void endLog();
}