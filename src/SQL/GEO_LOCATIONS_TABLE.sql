-- Executable from main schema (SYSTEM)
CREATE TABLE geo_locations
(
    geo_id NUMBER(38) not null,
    geo_name VARCHAR(50),
    geo_type VARCHAR(50),
    geo_latitude NUMBER(38),
    geo_longitude NUMBER(38),
    CONSTRAINT geo_pk PRIMARY KEY (geo_id)
);

CREATE SYNONYM locations FOR geo_locations;