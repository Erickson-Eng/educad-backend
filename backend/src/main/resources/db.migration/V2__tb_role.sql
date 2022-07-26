CREATE TABLE tb_role
(
    id            BIGINT       NOT NULL,
    role_name     VARCHAR(255) NOT NULL,
    created_date  date,
    modified_date date,
    CONSTRAINT pk_tb_role PRIMARY KEY (id)
);

ALTER TABLE tb_role
    ADD CONSTRAINT uc_tb_role_rolename UNIQUE (role_name);

