-- Create Table
CREATE TABLE loans (
    loan_id         NUMBER PRIMARY KEY,
    customer_name   VARCHAR2(100),
    loan_amount     NUMBER(12,2),
    annual_rate     NUMBER(5,2), 
    duration_years  NUMBER(3)
);

-- Insert Data
INSERT INTO loans VALUES (1, 'Alice', 500000, 8.5, 5);
INSERT INTO loans VALUES (2, 'Bob', 300000, 7.2, 3);
INSERT INTO loans VALUES (3, 'Charlie', 750000, 9.0, 10);

-- Display Data
SELECT * FROM loans;

-- Create Function
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount   IN NUMBER,
    p_annual_rate   IN NUMBER,
    p_years         IN NUMBER
) RETURN NUMBER
IS
    v_monthly_rate NUMBER := p_annual_rate / 12 / 100;
    v_months       NUMBER := p_years * 12;
    v_emi          NUMBER;
BEGIN
    v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) /
             (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
EXCEPTION
    WHEN OTHERS THEN
        RETURN NULL;
END;
/

-- Execute Function
SELECT
    loan_id,
    customer_name,
    loan_amount,
    CalculateMonthlyInstallment(loan_amount, annual_rate, duration_years) AS monthly_emi
FROM loans;
