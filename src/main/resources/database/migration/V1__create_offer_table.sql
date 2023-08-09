-- Create table for all offers
CREATE TABLE t_offer (
    id                 BIGINT          NOT NULL,
    description        VARCHAR(255)    NOT NULL,

    PRIMARY KEY (id)
);

-- Create sequence for t_offer
CREATE SEQUENCE sq_offer
    START WITH 1
    INCREMENT BY 50
    OWNED BY t_offer.id;
