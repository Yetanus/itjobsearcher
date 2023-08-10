-- portal.jj definition

-- Drop table

-- DROP TABLE portal.jj;

CREATE TABLE portal.jj (
                           id int4 NOT NULL,
                           "timestamp" date NOT NULL,
                           "money" varchar NOT NULL,
                           remote_possible bool NULL,
                           seniority varchar NULL,
                           years_of_exp varchar NULL,
                           requirements varchar NOT NULL,
                           "name" varchar NULL
);