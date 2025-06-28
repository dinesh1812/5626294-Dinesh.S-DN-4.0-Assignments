-- Create table
CREATE TABLE employees (
    emp_id      NUMBER PRIMARY KEY,
    emp_name    VARCHAR2(100),
    department  VARCHAR2(50),
    salary      NUMBER(10, 2)
);

-- Insert Data
INSERT INTO employees VALUES (101, 'Dinesh S', 'IT', 60000);
INSERT INTO employees VALUES (102, 'Ravi K', 'HR', 45000);
INSERT INTO employees VALUES (103, 'Priya R', 'Finance', 50000);

COMMIT;

-- Display Data
SELECT * FROM employees;

-- Create Procedure
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id        IN NUMBER,
    p_percent       IN NUMBER
) AS
    v_salary employees.salary%TYPE;
BEGIN
    -- Get Employee Current Salary
    SELECT salary INTO v_salary
    FROM employees
    WHERE emp_id = p_emp_id;

    -- Updates Salary
    UPDATE employees
    SET salary = v_salary + (v_salary * p_percent / 100)
    WHERE emp_id = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ID ' || p_emp_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

-- Execute Procedure
BEGIN
    UpdateSalary(101, 10);  -- Increases salary by 10%
END;

-- Error Handling
BEGIN
    UpdateSalary(999, 5);  -- Triggers NO_DATA_FOUND
END;
/