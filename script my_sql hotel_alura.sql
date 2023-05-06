CREATE SCHEMA IF NOT EXISTS hotel_alura;

use hotel_alura;

CREATE TABLE IF NOT EXISTS reservas(
id INT auto_increment PRIMARY KEY,
data_entrada DATE NOT NULL,
data_saida DATE NOT NULL,
valor VARCHAR (50),
forma_pagamento VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS hospedes(
id INT auto_increment PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
sobrenome VARCHAR(100) NOT NULL,
data_nascimento DATE NOT NULL,
nacionalidade VARCHAR (50),
telefone VARCHAR (50),
reserva_id INT
);

ALTER TABLE hospedes ADD CONSTRAINT fk_reservas FOREIGN KEY (reserva_id) references
reservas(id);

SELECT * FROM hospedes;

INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (
'2023-05-05',
'2023-05-06',
'200',
'cartão de débito'
);

INSERT INTO hospedes (nome, sobrenome, data_nascimento, nacionalidade, telefone, reserva_id) VALUES (
'DEBORAH',
'TELLES CARVALHO SANTOS',
'1995-11-20',
'brasileiro',
'33999666699',
2
);

SELECT h.nome, h.data_nascimento, h.telefone, r.data_entrada, r.data_saida, r.valor FROM hospedes AS h inner join reservas AS r on h.reserva_id = r.id;
