CREATE TYPE contract_type AS ENUM ('B2B', 'UOP', 'UZ', 'UOD');
CREATE TYPE technology_level AS ENUM ('NICE_TO_HAVE', 'BEGINNER', 'EXPERIENCED', 'SENIOR', 'EXPERT');

CREATE TABLE t_offer (
    uuid UUID NOT NULL,
    contract_type contract_type NOT NULL,
    salary_min BIGINT,
    salary_max BIGINT,
    required_experience_in_years BIGINT,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,

    PRIMARY KEY (uuid),

    CONSTRAINT salary_can_not_be_negative CHECK ( salary_min > 0 ),
    CONSTRAINT salary_max_can_not_be_negative CHECK ( salary_min > 0 ),
    CONSTRAINT salary_min_can_not_be_higher_as_salary_max CHECK ( salary_min >= t_offer.salary_max ),
    CONSTRAINT required_experience_in_years_can_not_be_negative CHECK ( required_experience_in_years >=0 )
);

CREATE TABLE t_offer_technology (
    uuid UUID NOT NULL,
    technology VARCHAR(255) NOT NULL,

    PRIMARY KEY (uuid)
);

CREATE TABLE t_offer_to_technology (
    offer_uuid UUID NOT NULL ,
    technology_uuid UUID NOT NULL,
    technology_level technology_level NOT NULL,

    PRIMARY KEY (offer_uuid, technology_uuid),
    FOREIGN KEY (offer_uuid) REFERENCES t_offer(uuid),
    FOREIGN KEY (technology_uuid) REFERENCES t_offer_technology(uuid)
);