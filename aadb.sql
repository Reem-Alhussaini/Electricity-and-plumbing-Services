CREATE TABLE invoice (
  invoice_number INT,
  name VARCHAR(255),
  phone_number VARCHAR(20),
  technician_name VARCHAR(255),
  service_name VARCHAR(255),
  total_price DECIMAL(10, 2)
);
CREATE TABLE user_info (
  name VARCHAR(255),
  phone_number VARCHAR(20),
  password VARCHAR(20)
);
INSERT INTO
  user_info (name, phone_number,password)
VALUES
  ('mohammed', '0548888888', 'md4653'),
  ('amjad', '0548888293', 'ad8293'),
  ('aseel', '0546528888', 'ss0212'),
  ('Othman', '0548888398', 'o999n'),
  ('Sameer', '0548073881', 'smsm511');
CREATE TABLE technician_info (
  name VARCHAR(255)
);
INSERT INTO
  technician_info (name)
VALUES
  ('jaleel'),
  ('abdulkareem'),
  ('jamal'),
  ('saeed'),
  ('ibrahim');