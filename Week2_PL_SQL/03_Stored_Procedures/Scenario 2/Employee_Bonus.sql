-- Create Table
CREATE TABLE employees(
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100),
    department VARCHAR(50),
    salary NUMBER(12,2)
);

-- Insert Data
INSERT INTO employees VALUES (1, 'Arun M', 'HR', 40000);
INSERT INTO employees VALUES (2, 'Priya R', 'IT', 60000);
INSERT INTO employees VALUES (3, 'Ravi S', 'IT', 55000);
INSERT INTO employees VALUES (4, 'Divya K', 'Finance', 50000);
INSERT INTO employees VALUES (5, 'Karthik N', 'IT', 48000);

COMMIT;

-- Display Data
SELECT * FROM employees;

-- Create Procedure
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE employees
    set salary = salary + (salary * p_bonus_percentage / 100)
    where department = p_department;
END;
/

-- Execute Procedure
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/