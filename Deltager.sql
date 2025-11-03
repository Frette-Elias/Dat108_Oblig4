DROP SCHEMA IF EXISTS dat108_oblig4 CASCADE;
CREATE SCHEMA dat108_oblig4;
SET search_path TO dat108_oblig4;

CREATE TABLE deltager (
                          mobil character (8) PRIMARY KEY,
                          fornavn character (40),
                          etternavn character (40),
                          kjonn character (6),
                          passord varchar (100) NOT NULL
);

INSERT INTO deltager (mobil, fornavn, etternavn, kjonn, passord)
VALUES
    ('12345678','Ola','Normann','Mann','1'),
    ('11223344','Per','Hansen','Mann','2'),
    ('44332211','Lise','Olsen','Kvinne','3'),
    ('55667788','Nina','Larsen','Kvinne','4'),
    ('87654321','Kari','Nordmann','Kvinne','5');