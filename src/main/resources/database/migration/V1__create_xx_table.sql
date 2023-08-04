-- INIT DB
CREATE TABLE jj (
                    id SERIAL PRIMARY KEY,
                    company VARCHAR (255) NOT NULL,
                    contract VARCHAR(10) NOT NULL,
                    money VARCHAR (50),
                    exp_lvl VARCHAR(10),
                    req_exp VARCHAR(100),
                    techs VARCHAR(100)
);

CREATE TABLE nofluff(
                        id SERIAL PRIMARY KEY,
                        company VARCHAR (255) NOT NULL,
                        money_uop VARCHAR(10) NOT NULL,
                        money_b2b VARCHAR(10) NOT NULL,
                        seniority VARCHAR (50),
                        req_exp VARCHAR(100),
                        nth_exp VARCHAR(100),
                        exp INT,
                        lang VARCHAR(100)
);
