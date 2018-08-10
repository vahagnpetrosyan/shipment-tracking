CREATE TABLE IF NOT EXISTS organizations (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  registry_number TEXT,
  contact_phone TEXT,
  contact_email TEXT
);


CREATE TABLE IF NOT EXISTS countries (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  code VARCHAR(2) NOT NULL
);


CREATE TABLE IF NOT EXISTS address (
  id SERIAL PRIMARY KEY,
  organization_id INTEGER,
  street VARCHAR(250),
  city VARCHAR(100),
  zipcode VARCHAR(10),
  country_id INTEGER REFERENCES countries (id)
);

CREATE TABLE IF NOT EXISTS projects (
  id SERIAL PRIMARY KEY ,
  project_number VARCHAR(10),
  shipment_type VARCHAR(10) CHECK ( shipment_type IN ('air', 'sea', 'road', 'rail') ),
  shipment_direction VARCHAR(10)  CHECK ( shipment_direction IN ('export', 'import', 'domestic') ),
  origin_id INTEGER NOT NULL REFERENCES countries (id),
  destination_id INTEGER NOT NULL REFERENCES countries (id),
  shipper_id INTEGER NOT NULL REFERENCES organizations (id),
  consignee_id INTEGER NOT NULL REFERENCES organizations (id),
  carrier_id INTEGER NOT NULL REFERENCES organizations (id),
  weight DOUBLE PRECISION,
  incoterms VARCHAR(3) CHECK ( incoterms IN ('EXW', 'FCA', 'FAS', 'FOB', 'CFR', 'CIF', 'CPT', 'DAF', 'DES', 'DDU', 'DDP', 'DAP') ),
  notes TEXT
);