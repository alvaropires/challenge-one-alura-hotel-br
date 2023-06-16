# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173164615-192ca98a-1a44-480e-9229-9f82f456eec8.png">

</p>

---
##  Primeiros Passos:

#### 🔹 Marque esse projeto com uma ⭐
#### 🔹 Siga as orientações do que temos neste repositório 📚
#### 🔹 Visite a página do desafio clicando aqui! [Link do Challenge](https://www.alura.com.br/challenges/oracle-one-back-end/hotelalura) 📃 
</br>

## 🖥️ Tecnologias Utilizadas:

- Java
- Eclipse
- MySql
- Biblioteca JCalendar
- Plugin WindowBuilder </br>

---
## ⚠️ Importante! ⚠️

☕ Use o Java na versão 8 ou superior para ter compatibilidade. 
</br></br>
📝 Recomendamos utilizar o editor Eclipse para compatibilidade da interface gráfica. </br></br>
🎨 A interface contém dois importantes métodos:
- setResizable(false): determina o tamanho da janela, e através do parâmetro <strong>false</strong>, a tela não poderá ser maximizada;
- setLocationRelativeTo(null): determina a localização da janela, e através do parâmetro <strong>null</strong> ele a mantém centralizada na tela.

#### Para este desafio, concentre-se na parte lógica e de conexão com o Banco de Dados, após concluir o desafio, sinta-se a vontade para incluir novas funcionalidades e modificar a interface gráfica. 


---



## Descrição do projeto

O projeto trata-se de um sistema de gerenciamento de reservas e hóspede para um hotel com dados persistidos em um Banco de Dados MySQL. As tabelas do banco de dados seguem um padrão de colunas com ID(chave primária gerada de forma sequencial pelo banco). As funcionalidades estão acessíveis a partir de um login do usuário.

A busca permite a pesquisa de reservas pelo número de reserva e de hóspedes a partir do sobrenome, utilizando o mesmo campo de pesquisa. É possível a edição e exlusão dos dados, desde que exista algum registro selecionado.

Foi utilizada a Linguagem Java para elaboração do projeto e a APIJDBC para conexão com o banco de dados. A interface gráfica foi desenvolvida utilizando a biblioteca Java Swing.

---

## Funcionalidades
- Login do Usuário
- Inclusão de reserva com cálculo automático do custo total das diárias
- Inclusão de um ou mais hóspedes para cada reserva
- Edição dos dados da reserva ou do hóspede a partir de seleção no menu de buscas
- Exclusão dos dados da reserva ou do hóspede a partir de seleção no menu de buscas
- Dados persistidos em Banco de Dados MySQL
---

## SQL/Banco de Dados

O script que cria as tabelas necessárias para o projeto pode ser obtido a partir do link abaixo:

[Script SQL para Criação das Tabelas](https://github.com/alvaropires/challenge-one-alura-hotel-br/blob/repositorio-base/script%20my_sql%20hotel_alura.sql)

```
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
```

O acesso ao Banco de Dados MySQL foi realizado a partir da API JDBC. Por padrão, o banco de dados do projeto foi criado com os seguintes atributos:

- url = "jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC"
- user = "root"
- password = "mysql"

A conexão com o Banco pode ser configurada alterando os seguintes atributos na classe [ConnectionFactory.java](https://github.com/alvaropires/challenge-one-alura-hotel-br/blob/repositorio-base/src/jdb/factory/ConnectionFactory.java):


```

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("SUA URL DE CONEXÃO");
		comboPooledDataSource.setUser("SEU USUÁRIO");
		comboPooledDataSource.setPassword("SUA SENHA");
		
		this.dataSource = comboPooledDataSource;
		
	}
	
	... Restante do Código Omitido
}
```





---

## Layout da Aplicação

---

## Como rodar a aplicação :arrow_forward:

---

## Desenvolvedor :octocat:

[<img src="https://avatars.githubusercontent.com/u/94912998?s=96&v=4" width=115><br><sub>Alvaro Pires Santos</sub>](https://github.com/alvaropires)


     
## 📬 Entrega

### Como incluir meu projeto com a "#" do desafio?

1) Tenha o <strong>Fork</strong> do projeto em seu repositório no Github.
2) Utilize o tópico **#challengeonealurahotelbr4**. Vá na aba esquerda do seu projeto na seção <em>About</em> e clique na engrenagem de configuração selecione o campo **topics** e insira a etiqueta **challengeonealurahotelbr4**.


![gif-vitrine](https://user-images.githubusercontent.com/91544872/153601047-62aee6cb-e3cf-42b3-92c3-7130c996113f.gif)

### Como faço a entrega final do meu Projeto?

4) Preencha o formulário a seguir com seus dados pessoais, juntamente com o link do seu repositório.🔹 [Link para o formulário](https://lp.alura.com.br/alura-latam-entrega-challenge-one-portugues-back-end)

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/91544872/218554361-c5fa616a-3232-4a21-998c-3b03fb7a0c8c.png">
</p>


5) Vá para seu e-mail e resgate sua badge conquistada por encerrar mais um desafio no Projeto ONE! 🏆

6) Não se esqueça de colocar um link ou vídeo de seu projeto no Linkedin! Marque com a #Oracle #AluraLatam 🏁


🧡 <strong>Oracle</strong></br>
<a href="https://www.linkedin.com/company/oracle/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

💙 <strong>Alura Latam</strong></br>
<a href="https://www.linkedin.com/company/alura-latam/mycompany/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
