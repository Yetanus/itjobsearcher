-- DROP SCHEMA archive;

CREATE SCHEMA archive AUTHORIZATION it_job_searcher_connect;
-- archive.archive definition

-- Drop table

-- DROP TABLE archive.archive;

CREATE TABLE archive.archive (
	"timestamp" date NULL,
	"money" varchar NOT NULL,
	"name" varchar NOT NULL,
	tech varchar NOT NULL,
	seniority varchar NULL
);
