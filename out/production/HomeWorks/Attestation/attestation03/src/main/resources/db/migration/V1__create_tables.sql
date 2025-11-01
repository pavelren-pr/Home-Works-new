CREATE TABLE IF NOT EXISTS owner (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(255),
  apartment_number VARCHAR(50),
  address VARCHAR(255),
  phone VARCHAR(50),
  is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS meter (
  id SERIAL PRIMARY KEY,
  owner_id INTEGER REFERENCES owner(id),
  type VARCHAR(50),
  serial_number VARCHAR(100),
  last_reading NUMERIC(14,4),
  last_reading_date DATE,
  is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS reading (
  id SERIAL PRIMARY KEY,
  meter_id INTEGER REFERENCES meter(id),
  reading_value NUMERIC(14,4),
  reading_date DATE,
  is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS payment (
  id SERIAL PRIMARY KEY,
  owner_id INTEGER REFERENCES owner(id),
  month DATE,
  amount NUMERIC(14,2),
  status VARCHAR(20),
  is_active BOOLEAN DEFAULT TRUE
);
