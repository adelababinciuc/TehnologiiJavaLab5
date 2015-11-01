--TO DO
--Ruleaza: 1. CREATE TABLE, 2. CREATE SEQUENCE, 3. CREATE FUNCTION, 4. CREATE TRIGGER

DROP TABLE project;

CREATE TABLE project(project_id SERIAL PRIMARY KEY, title varchar(45), description varchar(45), coordinator integer);

ALTER TABLE project ADD FOREIGN KEY (coordinator) REFERENCES lecturer(lecturer_id);

INSERT INTO project(title, description, coordinator) VALUES ('title', 'description', '1');

SELECT * FROM project;