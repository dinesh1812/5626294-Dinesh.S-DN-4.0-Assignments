package com.example.audit.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.inOrder;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.audit.model.AuditLogger;

@ExtendWith(MockitoExtension.class)
public class AuditServiceTest {

    @Mock
    private AuditLogger auditLogger;

    @InjectMocks
    private AuditService auditService;

    @Test
    public void testMethodCallOrder() {
        auditService.performAudit();

        InOrder inOrder = inOrder(auditLogger);
        inOrder.verify(auditLogger).startLog();
        inOrder.verify(auditLogger).writeLog("Audit in progress");
        inOrder.verify(auditLogger).endLog();
    }
}