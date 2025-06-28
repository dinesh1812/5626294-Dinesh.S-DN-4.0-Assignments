-- Create Table
CREATE TABLE accounts (
    account_id     NUMBER PRIMARY KEY,
    customer_name  VARCHAR2(100),
    balance        NUMBER(12,2)
);

-- Insert Data
INSERT INTO accounts VALUES (501, 'Dinesh S', 12000);
INSERT INTO accounts VALUES (502, 'Ravi K', 4000);

COMMIT;

-- Display data
SELECT * FROM accounts;

-- Create Function
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN
IS
    v_balance accounts.balance%TYPE;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;

    RETURN v_balance >= p_amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RETURN FALSE;
END;
/

-- Execute Function
DECLARE
    v_result BOOLEAN;
BEGIN
    v_result := HasSufficientBalance(501, 5000);

    IF v_result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance or account not found');
    END IF;
END;
/