DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
  id SERIAL PRIMARY KEY,
  first_name TEXT,
  last_name TEXT,
  email TEXT
);
