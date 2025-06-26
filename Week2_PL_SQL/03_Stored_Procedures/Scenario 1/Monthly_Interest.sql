-- Create Table
CREATE TABLE accounts(
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    account_type VARCHAR2(20),
    balance NUMBER(12,2)
);

-- Insert Data
INSERT INTO accounts VALUES (101, 'Dinesh', 'savings', 10000);
INSERT INTO accounts VALUES (102, 'Ravi', 'savings', 8000);
INSERT INTO accounts VALUES (103, 'Anita', 'current', 15000);
INSERT INTO accounts VALUES (104, 'Meena', 'savings', 20000);

COMMIT;

-- Display Data
SELECT * from accounts;

-- Create Procedure
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR account IN (SELECT account_id, balance from accounts where ACCOUNT_TYPE = 'savings') LOOP
    UPDATE accounts
    set balance = account.balance + (account.balance * 0.01)
    where account_id = account.account_id ;
    END LOOP;
END;
/

-- Execute Procedure
BEGIN
   ProcessMonthlyInterest;
END;
/