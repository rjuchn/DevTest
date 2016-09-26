-- Executable from main schema (SYSTEM)
create user app_client
identified by rafafal;

GRANT SELECT, INSERT, UPDATE ON GEO_LOCATIONS TO app_client;