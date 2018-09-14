DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
  id SERIAL PRIMARY KEY,
  firs_name TEXT,
  last_name TEXT,
  email TEXT
);
