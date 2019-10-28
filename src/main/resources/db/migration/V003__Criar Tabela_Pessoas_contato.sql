create table pessoa(
    idpessoa int not null auto_increment primary key,
    nomepessoa varchar(80));
    
    insert into pessoa(nomepessoa) values ('Rogério');
    insert into pessoa(nomepessoa) values ('Roseli');
    insert into pessoa(nomepessoa) values ('Rahul');
    insert into pessoa(nomepessoa) values ('Rodolpho');
    
    CREATE TABLE contato (
  codigo int PRIMARY KEY AUTO_INCREMENT,
	codigo_pessoa int NOT NULL,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
  FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(idpessoa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into contato (codigo, codigo_pessoa, nome, email, telefone) values (1, 1, 'Contato1', 'contato@contato.com.br', '00 0000-0000');