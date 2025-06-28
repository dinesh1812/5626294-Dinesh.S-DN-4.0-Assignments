-- Create Transaction table
CREATE TABLE transactions (
    txn_id         NUMBER PRIMARY KEY,
    account_id     NUMBER,
    amount         NUMBER(10,2),
    txn_type       VARCHAR2(20),
    txn_date       DATE DEFAULT SYSDATE
);

-- Insert Data
INSERT INTO transactions VALUES (101, 1, 5000, 'deposit', SYSDATE);
INSERT INTO transactions VALUES (102, 2, 2000, 'withdrawal', SYSDATE);
INSERT INTO transactions VALUES (103, 1, 1500, 'deposit', SYSDATE);
INSERT INTO transactions VALUES (104, 3, 7000, 'deposit', SYSDATE);

COMMIT;

-- Create Audit Log table
CREATE TABLE audit_log (
    log_id         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    txn_id         NUMBER,
    log_message    VARCHAR2(200),
    log_timestamp  DATE
);

-- Display Data
SELECT * FROM audit_log;

-- Create Trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (txn_id, log_message, log_timestamp)
    VALUES (
        :NEW.txn_id,
        'Transaction of Rs. ' || :NEW.amount || ' (' || :NEW.txn_type || ') inserted.',
        SYSDATE
    );
END;
/

-- Test Trigger
INSERT INTO transactions VALUES (106, 3, 3000, 'deposit', SYSDATE);