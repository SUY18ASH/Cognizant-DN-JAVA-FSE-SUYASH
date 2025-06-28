SET SERVEROUTPUT ON;

-- Scenario 1
DECLARE
    CURSOR CUR_LOANS IS
    SELECT
        L.LOANID,
        L.INTERESTRATE AS OLD_RATE,
        C.DOB
    FROM
             LOANS L
        JOIN CUSTOMERS C ON L.CUSTOMERID = C.CUSTOMERID;

    V_NEW_RATE NUMBER;
BEGIN
    FOR REC IN CUR_LOANS LOOP
        IF MONTHS_BETWEEN(SYSDATE, REC.DOB) / 12 > 60 THEN
            V_NEW_RATE := REC.OLD_RATE - 1;
            UPDATE LOANS
            SET
                INTERESTRATE = V_NEW_RATE
            WHERE
                LOANID = REC.LOANID;

            DBMS_OUTPUT.PUT_LINE('Loan '
                                 || REC.LOANID
                                 || ': '
                                 || REC.OLD_RATE
                                 || '% -> '
                                 || V_NEW_RATE
                                 || '%');

        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 2
BEGIN
    FOR CUST IN (
        SELECT
            CUSTOMERID,
            BALANCE
        FROM
            CUSTOMERS
    ) LOOP
        IF CUST.BALANCE > 10000 THEN
            UPDATE CUSTOMERS
            SET
                ISVIP = 'Y'
            WHERE
                CUSTOMERID = CUST.CUSTOMERID;

            DBMS_OUTPUT.PUT_LINE('Customer '
                                 || CUST.CUSTOMERID
                                 || ' marked VIP (Balance: '
                                 || CUST.BALANCE
                                 || ')');

        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3
BEGIN
    FOR DUE IN (
        SELECT
            L.LOANID,
            C.NAME    AS CUST_NAME,
            L.ENDDATE AS DUE_DATE
        FROM
                 LOANS L
            JOIN CUSTOMERS C ON L.CUSTOMERID = C.CUSTOMERID
        WHERE
            L.ENDDATE BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan '
                             || DUE.LOANID
                             || ' for '
                             || DUE.CUST_NAME
                             || ' is due on '
                             || TO_CHAR(DUE.DUE_DATE, 'YYYY-MM-DD'));
    END LOOP;
END;
/
