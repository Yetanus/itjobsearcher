-- Create table for all techs
CREATE TYPE techs AS ENUM ('JAVA', 'C++', 'KOTLIN', 'REACT', 'ANGULAR', 'JAVASCRIPT', 'TYPESCRIPT',
                            'C', 'PYTHON', 'REDUX', 'SQL', 'SPRING', 'SPRING BOOT', 'DOCKER', 'KUBERNETES',
                            'KAFKA', 'AWS', 'AZURE', 'GOOGLE CLOUD', 'UNIT TESTING', 'AUTOMATION',
                            'AUTOMATED TESTING', 'MAVEN', 'VUE.JS', 'XAMARIN', 'NOSQL', 'SCRUM', 'HIBERNATE');
CREATE TABLE t_tech (
                         id                 BIGINT          NOT NULL,
                         technology         techs           NOT NULL,

                         PRIMARY KEY (id)
);

-- Create sequence for t_tech
CREATE SEQUENCE sq_tech
    START WITH 1
    INCREMENT BY 1
    OWNED BY t_tech.id;
