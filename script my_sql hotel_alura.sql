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
