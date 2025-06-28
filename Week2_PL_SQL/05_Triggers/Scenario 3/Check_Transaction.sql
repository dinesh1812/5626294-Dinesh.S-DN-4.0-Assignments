-- Create Accounts Table
CREATE TABLE accounts (
    account_id   NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    balance       NUMBER(12,2)
);

-- Insert Data
INSERT INTO accounts VALUES (1, 'Alice', 10000);
INSERT INTO accounts VALUES (2, 'Bob', 5000);
INSERT INTO accounts VALUES (3, 'Charlie', 15000);
INSERT INTO accounts VALUES (4, 'David', 20000);

COMMIT;

-- Create Transaction table
CREATE TABLE transactions (
    txn_id         NUMBER PRIMARY KEY,
    account_id     NUMBER,
    amount         NUMBER(10,2),
    txn_type       VARCHAR2(20),
    txn_date       DATE DEFAULT SYSDATE
);

-- Display Data
SELECT * FROM transactions;

-- Create Trigger
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
    v_balance accounts.balance%TYPE;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = :NEW.account_id;

    IF :NEW.txn_type = 'deposit' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be positive.');
    END IF;

    IF :NEW.txn_type = 'withdrawal' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Withdraw amount Cannot be zero');
    END IF;

    IF :NEW.txn_type = 'withdrawal' AND :NEW.amount > v_balance THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance for withdrawal.');
    END IF;

END;
/

-- Test Trigger
INSERT INTO transactions VALUES (201, 1, 3000, 'deposit', SYSDATE);

-- Invalid deposit
--INSERT INTO transactions VALUES (202, 2, -500, 'deposit', SYSDATE);

-- Valid withdrawal
INSERT INTO transactions VALUES (203, 1, 2000, 'withdrawal', SYSDATE);

-- Invalid withdrawal
--INSERT INTO transactions VALUES (204, 3, 100000, 'withdrawal', SYSDATE);


drop table accounts;
drop table transactions;
drop TRIGGER CheckTransactionRules;