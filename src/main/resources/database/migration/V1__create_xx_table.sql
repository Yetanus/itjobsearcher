CREATE USER it_job_searcher_connect WITH ENCRYPTED PASSWORD 'it_job_searcher_connect';
CREATE DATABASE it_job_searcher;
GRANT ALL PRIVILEGES ON DATABASE it_job_searcher TO it_job_searcher_connect;
CREATE SCHEMA portal;
CREATE SCHEMA archive;
