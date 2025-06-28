create database academico;
USE academico;

CREATE TABLE curso (
   sigla CHAR(3) primary key,
   nome VARCHAR(60),
   coordenador VARCHAR(45)
);

create table aluno (
    pront varchar(9) primary key,
    nome varchar(60),
    ano_ingresso int,
    sigla_curso varchar(3),
    foreign key (sigla_curso) references curso(sigla)
);

create table usuario (
    id int auto increment,
    usuario varchar (30),
    senha varchar (8),
    papel varchar (20),
    primary key (id)
);

INSERT INTO curso VALUES ("BCC", 
        "Bacharelado em Ciência da Computação",
        "Kleber" );

insert into aluno values ("pe3015564", "Genilson Junior", 2022, "BCC");

SELECT * FROM curso;
Select * from aluno;

INSERT INTO curso VALUES ("ADS", 
        "Análise e Desenvolvimento de Sistemas",
        "Andrea" );

UPDATE curso SET coordenador="Vilson", nome="dfsdfsfsdfsfs" WHERE sigla="ADS";