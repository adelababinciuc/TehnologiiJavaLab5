--TO DO
--Ruleaza: 1. CREATE TABLE, 2. CREATE SEQUENCE, 3. CREATE FUNCTION, 4. CREATE TRIGGER

DROP TABLE lecturer;

CREATE TABLE lecturer(lecturer_id SERIAL PRIMARY KEY, name varchar(45), specialization varchar(45));

INSERT INTO lecturer(name, specialization) VALUES ('andrei', 'gfd');

SELECT * FROM lecturer;