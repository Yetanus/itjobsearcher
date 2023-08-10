-- portal.nofluff definition

-- Drop table

-- DROP TABLE portal.nofluff;

CREATE TABLE portal.nofluff (
                                id int4 NOT NULL,
                                "money" varchar NOT NULL,
                                category varchar NOT NULL,
                                seniority varchar NOT NULL,
                                required varchar NOT NULL,
                                additional varchar NULL,
                                "name" varchar NULL
);