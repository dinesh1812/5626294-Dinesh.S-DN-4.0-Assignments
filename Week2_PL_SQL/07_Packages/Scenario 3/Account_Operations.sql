-- Create Data
CREATE TABLE ACCOUNT (
    account_id     NUMBER PRIMARY KEY,
    customer_id    NUMBER,
    account_type   VARCHAR2(30),
    balance        NUMBER(12,2),
    status         VARCHAR2(10)
);

-- Insert Data
INSERT INTO ACCOUNT VALUES (201, 1, 'Savings', 12000.50, 'Active');
INSERT INTO ACCOUNT VALUES (202, 1, 'Current', 8000.00, 'Active');
INSERT INTO ACCOUNT VALUES (203, 2, 'Savings', 15000.00, 'Active');
INSERT INTO ACCOUNT VALUES (204, 3, 'Fixed', 50000.00, 'Active');
INSERT INTO ACCOUNT VALUES (205, 3, 'Savings', 10000.00, 'Active');

COMMIT;

-- Display Data
SELECT * FROM account;

-- Create Package Structure
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id IN NUMBER
    );

    FUNCTION GetTotalBalance(p_customer_id IN NUMBER) RETURN NUMBER;
END AccountOperations;

-- Create Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    ) IS
    BEGIN
        INSERT INTO ACCOUNT (account_id, customer_id, account_type, balance, status)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, 'Active');
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_account_id IN NUMBER
    ) IS
    BEGIN
        UPDATE ACCOUNT
        SET status = 'Closed'
        WHERE account_id = p_account_id;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_total NUMBER := 0;
    BEGIN
        SELECT NVL(SUM(balance), 0)
        INTO v_total
        FROM ACCOUNT
        WHERE customer_id = p_customer_id AND status = 'Active';

        RETURN v_total;
    END GetTotalBalance;

END AccountOperations;

-- Open new account
BEGIN
    AccountOperations.OpenAccount(206, 2, 'Current', 7000);
END;
/

-- Close an account
BEGIN
    AccountOperations.CloseAccount(202);
END;
/

-- Get total balance for customer_id = 1
DECLARE
    total NUMBER;
BEGIN
    total := AccountOperations.GetTotalBalance(1);
    DBMS_OUTPUT.PUT_LINE('Total Active Balance: ' || total);
END;
/

drop table account;
drop PACKAGE AccountOperations;