CREATE TABLE tb_user
(
    id            BIGINT       NOT NULL,
    username      VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NOT NULL,
    email         VARCHAR(150) NOT NULL,
    created_date  date,
    modified_date date,
    CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

ALTER TABLE tb_user
    ADD CONSTRAINT uc_tb_user_email UNIQUE (email);

ALTER TABLE tb_user
    ADD CONSTRAINT uc_tb_user_username UNIQUE (username);