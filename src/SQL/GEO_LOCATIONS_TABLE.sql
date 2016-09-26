-- Executable from main schema (SYSTEM)
CREATE TABLE geo_locations
(
    geo_id INTEGER not null,
    geo_name VARCHAR(50),
    geo_type VARCHAR(50),
    geo_latitude VARCHAR(50),
    geo_longitude VARCHAR(50),
    CONSTRAINT geo_pk PRIMARY KEY (geo_id)
);

CREATE SYNONYM locations FOR geo_locations;