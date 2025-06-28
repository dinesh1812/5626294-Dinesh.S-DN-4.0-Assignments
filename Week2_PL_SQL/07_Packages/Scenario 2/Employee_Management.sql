-- Create Table
CREATE TABLE EMPLOYEE (
    emp_id        NUMBER PRIMARY KEY,
    name          VARCHAR2(100),
    job_title     VARCHAR2(50),
    salary        NUMBER(10, 2),
    department    VARCHAR2(50)
);

-- Insert Data
INSERT INTO EMPLOYEE VALUES (101, 'Raj Kumar', 'Software Engineer', 60000, 'IT');
INSERT INTO EMPLOYEE VALUES (102, 'Priya Mehta', 'Data Analyst', 55000, 'Analytics');
INSERT INTO EMPLOYEE VALUES (103, 'Anil Rao', 'HR Executive', 40000, 'HR');

COMMIT;

-- Display Data
SELECT * FROM employee;

-- Create Package Structure
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_job_title  IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_job_title  IN VARCHAR2,
        p_department IN VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(p_emp_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;

-- Create Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_job_title  IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO EMPLOYEE (emp_id, name, job_title, salary, department)
        VALUES (p_emp_id, p_name, p_job_title, p_salary, p_department);
    END HireEmployee;

    PROCEDURE UpdateEmployee(
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_job_title  IN VARCHAR2,
        p_department IN VARCHAR2
    ) IS
    BEGIN
        UPDATE EMPLOYEE
        SET name = p_name,
            job_title = p_job_title,
            department = p_department
        WHERE emp_id = p_emp_id;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_emp_id IN NUMBER) RETURN NUMBER IS
        v_salary EMPLOYEE.salary%TYPE;
    BEGIN
        SELECT salary INTO v_salary
        FROM EMPLOYEE
        WHERE emp_id = p_emp_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END CalculateAnnualSalary;

END EmployeeManagement;


-- Hire new employee
BEGIN
    EmployeeManagement.HireEmployee(106, 'Karthik B', 'Business Analyst', 65000, 'Strategy');
END;
/

-- Update existing employee
BEGIN
    EmployeeManagement.UpdateEmployee(102, 'Priya M', 'Senior Data Analyst', 'Analytics');
END;
/

-- Calculate annual salary
DECLARE
    annual_sal NUMBER;
BEGIN
    annual_sal := EmployeeManagement.CalculateAnnualSalary(101);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || annual_sal);
END;
/