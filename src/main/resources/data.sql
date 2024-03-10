INSERT INTO
    application_user (first_name, last_name, email, password)
VALUES
    -- superadmin@example.com / hard
    ('Jan', 'Kowalski', 'superadmin@example.com', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S'),
    -- john@example.com / dog.8
    ('Dawid', 'Abacki', 'dave@example.com', '{MD5}{AlZCLSQMMNLBS5mEO0kSem9V3mxplC6cTjWy9Kj/Gxs=}d9007147eb3a5f727b2665d647d36e35'),
    -- java_lover@example.com / javaiscool
    ('Anna', 'Zalewska', 'zalew.ann@example.com', '{argon2}$argon2id$v=19$m=4096,t=3,p=1$YBBBwx+kfrNgczYDcLlWYA$LEPgdtfskoobyFtUWTMejaE5SBRyieHYbiE5ZmFKE7I');


INSERT INTO
    user_role (name, description)
VALUES
    ('ADMIN', 'Ma dostęp do wszystkiego'),
    ('USER', 'Dostęp tylko do odczytu');

INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);

INSERT INTO category (name)
values
    ('Jedzenie'), ('Leki'), ('Inwestycje'), ('Rachunki');

INSERT INTO budget(name, amount, start_date, end_date, state, user_id, category_id)
VALUES ('Wydatki domowe', 2500, '2023-09-01', '2023-09-30', 0,2, 1),
       ('Opłaty' , 2000, '2023-09-01', '2023-09-30', 0,2 , 1),
       ('Wyjazd nad morze' , 3500.76, '2023-09-01', '2023-09-30', 0,3, 1);

INSERT INTO planned_expense (name,amount, planned_expense_state, budget_id, category_id)
values ('Zakupy spozywcze', 2000.0, 0, 1, 1),
       ('Czynsz za mieszkanie', 712.60, 0, 2, 4),
       ('Czesne', 350,1, 2, 3);


INSERT INTO expense (name, amount, expense_date,category_id, user_id)
VALUES ('Zakupy na cały tydzień w Lidlu', 254.97, '2023-09-11', 1,2),
       ('Opłata za wynajem', 750, '2023-08-31', 4, 3),
       ('Tankowanie auta', 316.54, '2023-09-09', 4,2);

