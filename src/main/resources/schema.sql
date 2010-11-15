SET IGNORECASE TRUE;

CREATE TABLE clients (
    id BIGINT NOT NULL,
    login_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    last_login DATE,
    PRIMARY KEY (id)
);

CREATE TABLE products (
    id BIGINT NOT NULL,
    version BIGINT,
    product_name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL,
    added DATE,
    PRIMARY KEY (id)
);

CREATE TABLE orders (
  id BIGINT NOT NULL,
  version BIGINT,
  product_id BIGINT NOT NULL,
  client_id BIGINT NOT NULL,
  order_date DATE,
  PRIMARY KEY(id)
);


