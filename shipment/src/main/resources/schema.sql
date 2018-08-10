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
  country_id INTEGER
);
ALTER TABLE address ADD CONSTRAINT address_country_id_fk FOREIGN KEY (country_id) REFERENCES countries (id);


CREATE TABLE IF NOT EXISTS projects (
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

ALTER TABLE projects ADD constraint projects_id_pk PRIMARY KEY (id);

ALTER TABLE projects ADD CONSTRAINT projects_origin_id_fk FOREIGN KEY (origin_id) REFERENCES countries (id);
ALTER TABLE projects ADD CONSTRAINT projects_destination_id_fk FOREIGN KEY (destination_id) REFERENCES countries (id);

ALTER TABLE projects ADD CONSTRAINT projects_shipper_id_fk FOREIGN KEY (shipper_id) REFERENCES organizations (id);
ALTER TABLE projects ADD CONSTRAINT projects_consignee_id_fk FOREIGN KEY (consignee_id) REFERENCES organizations (id);
ALTER TABLE projects ADD CONSTRAINT projects_carrier_id_fk FOREIGN KEY (carrier_id) REFERENCES organizations (id);

ALTER TABLE projects ADD CONSTRAINT projects_shipment_type_chk CHECK ( shipment_type IN ('air', 'sea', 'road', 'rail') );
ALTER TABLE projects ADD CONSTRAINT projects_shipment_direction_chk CHECK ( shipment_direction IN ('export', 'import', 'domestic') );
ALTER TABLE projects ADD CONSTRAINT projects_incoterms_chk CHECK ( incoterms IN ('EXW', 'FCA', 'FAS', 'FOB', 'CFR', 'CIF', 'CPT', 'DAF', 'DES', 'DDU', 'DDP', 'DAP') );