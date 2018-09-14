CREATE TABLE organizations (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  registry_number TEXT,
  contact_phone TEXT,
  contact_email TEXT
);


CREATE TABLE countries (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  code VARCHAR(2) NOT NULL
);


CREATE TABLE address (
  id SERIAL PRIMARY KEY,
  organization_id INTEGER UNIQUE,
  street VARCHAR(250),
  city VARCHAR(100),
  zipcode VARCHAR(10),
  country_id INTEGER
);

CREATE TABLE projects (
  id SERIAL,
  project_number VARCHAR(10),
  shipment_type VARCHAR(10),
  shipment_direction VARCHAR(10),
  origin_id INTEGER NOT NULL,
  destination_id INTEGER NOT NULL,
  shipper_id INTEGER NOT NULL,
  consignee_id INTEGER NOT NULL,
  carrier_id INTEGER NOT NULL,
  weight DOUBLE PRECISION,
  incoterms VARCHAR(3),
  notes TEXT
);