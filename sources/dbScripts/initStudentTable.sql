--TO DO
--Ruleaza: 1. CREATE TABLE, 2. CREATE SEQUENCE, 3. CREATE FUNCTION, 4. CREATE TRIGGER

DROP TABLE student;

CREATE TABLE student(student_id SERIAL PRIMARY KEY, name varchar(45), cnp varchar(45), placeOfBirth varchar(45));

INSERT INTO student(name , cnp, placeOfBirth) VALUES ('ana', '123', 'fcs');

SELECT * FROM student;
