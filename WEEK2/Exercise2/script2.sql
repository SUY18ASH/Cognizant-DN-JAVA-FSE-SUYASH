SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE PROCEDURE PROCESSMONTHLYINTEREST IS
BEGIN
    FOR ACCT IN (
        SELECT
            ACCOUNTID,
            BALANCE
        FROM
            ACCOUNTS
        WHERE
            ACCOUNTTYPE = 'Savings'
    ) LOOP
        UPDATE ACCOUNTS
        SET
            BALANCE = ACCT.BALANCE * 1.01
        WHERE
            ACCOUNTID = ACCT.ACCOUNTID;

        DBMS_OUTPUT.PUT_LINE('Account '
                             || ACCT.ACCOUNTID
                             || ' old bal: '
                             || ACCT.BALANCE
                             || ' new bal: '
                             || ROUND(ACCT.BALANCE * 1.01, 2));

    END LOOP;

    COMMIT;
END;
/

-- Demo call
BEGIN
    PROCESSMONTHLYINTEREST;
END;
/

-- Scenario 2
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEEBONUS (
    P_DEPARTMENT IN VARCHAR2,
    P_BONUSPCT   IN NUMBER
) IS
    V_OLD_SALARY NUMBER;
    V_NEW_SALARY NUMBER;
BEGIN
    FOR EMP IN (
        SELECT
            EMPLOYEEID,
            SALARY
        FROM
            EMPLOYEES
        WHERE
            DEPARTMENT = P_DEPARTMENT
    ) LOOP
        V_OLD_SALARY := EMP.SALARY;
        V_NEW_SALARY := V_OLD_SALARY * ( 1 + P_BONUSPCT / 100 );
        UPDATE EMPLOYEES
        SET
            SALARY = V_NEW_SALARY
        WHERE
            EMPLOYEEID = EMP.EMPLOYEEID;

        DBMS_OUTPUT.PUT_LINE('Emp '
                             || EMP.EMPLOYEEID
                             || ' dept='
                             || P_DEPARTMENT
                             || ' old Sal: '
                             || V_OLD_SALARY
                             || ' new Sal: '
                             || ROUND(V_NEW_SALARY, 2));

    END LOOP;

    COMMIT;
END;
/

-- 2Demo call
BEGIN
    UPDATEEMPLOYEEBONUS('IT', 10);
END;
/

-- Scenario 3
CREATE OR REPLACE PROCEDURE TRANSFERFUNDS (
    P_SOURCEACCT IN NUMBER,
    P_DESTACCT   IN NUMBER,
    P_AMOUNT     IN NUMBER
) IS
    V_SRC_BALANCE NUMBER;
BEGIN
    SELECT
        BALANCE
    INTO V_SRC_BALANCE
    FROM
        ACCOUNTS
    WHERE
        ACCOUNTID = P_SOURCEACCT;

    IF P_AMOUNT <= V_SRC_BALANCE THEN
        UPDATE ACCOUNTS
        SET
            BALANCE = BALANCE - P_AMOUNT
        WHERE
            ACCOUNTID = P_SOURCEACCT;

        UPDATE ACCOUNTS
        SET
            BALANCE = BALANCE + P_AMOUNT
        WHERE
            ACCOUNTID = P_DESTACCT;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transferred '
                             || P_AMOUNT
                             || ' from '
                             || P_SOURCEACCT
                             || ' to '
                             || P_DESTACCT);

    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient funds in account '
                             || P_SOURCEACCT
                             || ' (available: '
                             || V_SRC_BALANCE
                             || ')');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('One of the account IDs not found.');
END;
/

-- 3Demo call
BEGIN
    TRANSFERFUNDS(1, 2, 500);
END;
/