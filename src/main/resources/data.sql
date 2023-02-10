INSERT INTO ACCOUNT (id, number) VALUES (1, 'SAL0AD1');
INSERT INTO PARTY (id, name, address, account_id) VALUES (1, 'Aakash Kumar', 'Pune', 1);
INSERT INTO PARTY (id, name, address, account_id) VALUES (2, 'Aaditya Kumar', 'Pune', 1);
INSERT INTO PARTY (id, name, address, account_id) VALUES (3, 'Kavita Raikwar', 'Pune', 1);

INSERT INTO TRANSACTION (id, amount, type, account_id) VALUES (1, 100, 'CREDIT', 1);
INSERT INTO TRANSACTION (id, amount, type, account_id) VALUES (2, 50, 'DEBIT', 1);

