CREATE TABLE t_jj_offer (
    uuid                        UUID            NOT NULL,
    title                       VARCHAR(255)    NOT NULL,
    required_skills             text,
    nice_to_have_skills         text,
    workplace_type              varchar(255),
    working_time                varchar(255),
    experience_level            varchar(255),
    multilocation               text,
    company_city                varchar(255)    NOT NULL,
    company_street              varchar(255)    NOT NULL,
    company_name                varchar(255)    NOT NULL,
    published_at                DATE            NOT NULL,
    offer_body                  text            NOT NULL,

    PRIMARY KEY (uuid)

);

CREATE TABLE t_jj_offer_salary_range(
    offer_uuid              uuid            NOT NULL,
    to_b2b                  BIGINT,
    from_b2b                BIGINT,
    to_permanent            BIGINT,
    from_permanent          BIGINT,
    to_uz                   BIGINT,
    from_uz                 BIGINT,
    to_ud                   BIGINT,
    from_ud                 BIGINT,

    PRIMARY KEY (offer_uuid),
    FOREIGN KEY(offer_uuid) REFERENCES t_jj_offer(uuid)
);