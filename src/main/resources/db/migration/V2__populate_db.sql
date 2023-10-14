INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
('Vladyslav', '1990-05-15', 'Trainee', 800),
('Andrii', '1985-02-20', 'Junior', 1200),
('Oleksandr', '1988-05-10', 'Middle', 2500),
('Eva', '1975-08-05', 'Senior', 6000),
('Mykhailo', '1993-03-25', 'Trainee', 900),
('Olena', '1982-07-15', 'Junior', 1300),
('Maksym', '1982-09-30', 'Middle', 2800),
('Sophia', '1978-04-12', 'Senior', 7000),
('Anna', '1991-06-18', 'Trainee', 950),
('Kateryna', '1986-10-22', 'Junior', 1400);

INSERT INTO client (NAME)
VALUES
('Client One'),
('Client Two'),
('Client Three'),
('Client Four'),
('Client Five');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
(1, '2023-01-01', '2023-06-30'),
(2, '2023-02-15', '2023-05-15'),
(3, '2023-03-10', '2023-08-10'),
(4, '2023-04-15', '2023-09-25'),
(5, '2023-05-20', '2023-07-05'),
(1, '2023-04-05', '2023-09-05'),
(2, '2023-05-20', '2023-10-20'),
(3, '2023-10-15', '2024-03-15'),
(4, '2023-08-25', '2024-01-25'),
(5, '2023-09-30', '2024-02-28');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 3),
(3, 4),
(4, 4),
(4, 5),
(5, 5),
(5, 1),
(6, 5),
(7, 2),
(7, 3),
(8, 4),
(9, 1),
(9, 4),
(10, 5),
(10, 3);

--Добавив щодо вирішення завдання 5.
UPDATE project
SET NAME = CONCAT('Project ', CHAR(64 + ID))
WHERE ID IS NOT NULL;
