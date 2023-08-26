CREATE TABLE IF NOT EXISTS clients(
     client_id INT PRIMARY KEY,
     name VARCHAR,
     surname VARCHAR,
     id_card INT CONSTRAINT card_id REFERENCES card(card_id)
    );
CREATE TABLE IF NOT EXISTS card(
     card_id INT PRIMARY KEY,
     verNumber VARCHAR,
     money INT,
     id_bank INT CONSTRAINT bank REFERENCES banks(bank_id)

    );
CREATE TABLE IF NOT EXISTS banks(
     bank_id INT PRIMARY KEY,
     title VARCHAR
);

INSERT INTO banks (bank_id, title)
VALUES (1, 'SBERBANK'),
       (2, 'ALPHABANK'),
       (3, 'BELARUSBANK'),
       (4, 'IDEABANK');