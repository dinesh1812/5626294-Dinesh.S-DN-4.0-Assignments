-- Create Table
CREATE TABLE transactions (
    txn_id       NUMBER PRIMARY KEY,
    account_id   NUMBER,
    amount       NUMBER(10,2),
    txn_type     VARCHAR2(20),
    txn_date     DATE
);

-- Insert Data
INSERT INTO transactions VALUES (301, 1, 5000, 'deposit', SYSDATE);
INSERT INTO transactions VALUES (302, 1, 1000, 'withdrawal', SYSDATE - 1);
INSERT INTO transactions VALUES (303, 2, 3000, 'deposit', SYSDATE - 10);

COMMIT;

-- Display Data
SELECT * FROM transactions;

-- Declare Cursor
DECLARE
    CURSOR txn_cursor IS
        SELECT account_id, txn_type, amount, txn_date
        FROM transactions
        WHERE TO_CHAR(txn_date, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY account_id;
    v_account_id transactions.account_id%TYPE;
    v_txn_type   transactions.txn_type%TYPE;
    v_amount     transactions.amount%TYPE;
    v_txn_date   transactions.txn_date%TYPE;
-- Execute Cursor
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Monthly Statement ---');
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_account_id, v_txn_type, v_amount, v_txn_date;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Account: ' || v_account_id ||
                             ' | Type: ' || v_txn_type ||
                             ' | Amount: ' || v_amount ||
                             ' | Date: ' || TO_CHAR(v_txn_date, 'DD-Mon-YYYY'));
    END LOOP;
    CLOSE txn_cursor;
END;
/