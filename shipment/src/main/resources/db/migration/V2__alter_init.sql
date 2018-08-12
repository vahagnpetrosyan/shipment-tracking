ALTER TABLE projects ADD constraint projects_id_pk PRIMARY KEY (id);
ALTER TABLE address ADD CONSTRAINT address_country_id_fk FOREIGN KEY (country_id) REFERENCES countries (id);

ALTER TABLE projects ADD CONSTRAINT projects_origin_id_fk FOREIGN KEY (origin_id) REFERENCES countries (id);
ALTER TABLE projects ADD CONSTRAINT projects_destination_id_fk FOREIGN KEY (destination_id) REFERENCES countries (id);

ALTER TABLE projects ADD CONSTRAINT projects_shipper_id_fk FOREIGN KEY (shipper_id) REFERENCES organizations (id);
ALTER TABLE projects ADD CONSTRAINT projects_consignee_id_fk FOREIGN KEY (consignee_id) REFERENCES organizations (id);
ALTER TABLE projects ADD CONSTRAINT projects_carrier_id_fk FOREIGN KEY (carrier_id) REFERENCES organizations (id);

ALTER TABLE projects ADD CONSTRAINT projects_shipment_type_chk CHECK ( shipment_type IN ('air', 'sea', 'road', 'rail') );
ALTER TABLE projects ADD CONSTRAINT projects_shipment_direction_chk CHECK ( shipment_direction IN ('export', 'import', 'domestic') );
ALTER TABLE projects ADD CONSTRAINT projects_incoterms_chk CHECK ( incoterms IN ('EXW', 'FCA', 'FAS', 'FOB', 'CFR', 'CIF', 'CPT', 'DAF', 'DES', 'DDU', 'DDP', 'DAP') );