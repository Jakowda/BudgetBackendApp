DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE application_user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(200) NOT NULL
);
CREATE TABLE user_role
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        varchar(30)  NOT NULL,
    description varchar(250)
);

CREATE TABLE user_roles
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES application_user(id),
    FOREIGN KEY (role_id) REFERENCES user_role(id)
);
CREATE TABLE category(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE budget (
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    amount DOUBLE,
    start_date DATE,
    end_date DATE,
    state tinyint check (state between 0 and 1),
    user_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES application_user(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE expense
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    expense_date DATE,
    category_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES application_user(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE planned_expense
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    planned_expense_state tinyint check (planned_expense_state between 0 and 1),
    budget_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (budget_id) REFERENCES budget(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE income
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    income_date DATE,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES application_user(id)
);