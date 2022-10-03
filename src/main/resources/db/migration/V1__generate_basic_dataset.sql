INSERT INTO applicants (first_name, last_name, ssn, city, street, number, zip, apt)
VALUES ('-_-', '-_-', '-_-', '-_-', '-_-', 0000000000, 00000, 0);
INSERT INTO applicants (first_name, last_name, ssn, city, street, number, zip, apt)
VALUES ('Kirill', 'K', '12345678', 'Kyiv', 'some_street', 09333333333, 01001, 4);

INSERT INTO advisors (first_name, last_name, role) VALUES ('Oleg', 'O', 'ASSOCIATE');
INSERT INTO advisors (first_name, last_name, role) VALUES ('Senior Oleg', 'O', 'SENIOR');

INSERT INTO applications (amount, status, assigned_at, applicant_id, advisor_id)
VALUES (50001, 'ASSIGNED', now(), 1, 2);
INSERT INTO applications (amount, status, applicant_id)
VALUES (50002, 'NEW', 1);
INSERT INTO applications (amount, status, applicant_id)
VALUES (50003, 'NEW', 1);