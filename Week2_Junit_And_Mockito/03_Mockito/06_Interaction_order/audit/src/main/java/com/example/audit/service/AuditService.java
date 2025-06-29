package com.example.audit.service;

import com.example.audit.model.AuditLogger;

public class AuditService {
    private AuditLogger logger;

    public AuditService(AuditLogger logger) {
        this.logger = logger;
    }

    public void performAudit() {
        logger.startLog();
        logger.writeLog("Audit in progress");
        logger.endLog();
    }
}