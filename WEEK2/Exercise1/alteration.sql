-- ALTER TABLE Customers
--   ADD IsVIP CHAR(1) DEFAULT 'N';

-- Custom insertions
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (10, 'Elder One', TO_DATE('1950-01-01','YYYY-MM-DD'), 5000, SYSDATE);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (10, 10, 2000, 6, SYSDATE, SYSDATE + 10);  -- due in 10 days

UPDATE Customers SET Balance = 20000 WHERE CustomerID = 10;
COMMIT;
