CREATE TABLE recipe
(
    id          BIGINT  NOT NULL,
    favorite    BOOLEAN NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_recipe PRIMARY KEY (id)
);