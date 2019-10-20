CREATE TABLE owners (
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE pets (
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  kind varchar(255),
  owner_id int,
  PRIMARY KEY(id),
  FOREIGN KEY(owner_id) REFERENCES owners(id)
);