
create database if not exists academico;
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
drop table usuario;
create table usuario (
    /*id int,*/
    user varchar (30),
    senha varchar (8),
    papel varchar (20),
    primary key (user)
);

insert into usuario values ("admin", "93218", "admin");
insert into usuario (user, senha, papel) values("junin","1234","simples");

select * from usuario where user = 'admin' and senha = '9321';
select * from usuario;

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
update aluno set sigla_curso = "ADS" where pront="pe3015564";

select * from aluno a join curso c on a.sigla_curso = c.sigla;

delete from aluno where pront = "pe3015564";