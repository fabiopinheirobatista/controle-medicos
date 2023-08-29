# controle-medicos
Back-end Java para realizar controle de médicos

O projeto está confogurado para ser executado na porta localhost:9090
Como alguns scripts via migration apresentaram erros, foram necessários alguns scripts manuais na base de dados.
Os mesmos seguem abaixo e também no anexo no arquivo chamado SCRIPT.SQL

## Criar tabela pacientes
create table pacientes(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(14) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    telefone varchar(20) not null,
    ativo tinyint not null,

    primary key(id)
);

##Criar tabela usuários
create table usuarios(
    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)
);

##Criar tabela consultas
create table consultas(
    id bigint not null auto_increment,
    medico_id bigint not null,
    paciente_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_consultas_medico_id foreign key(medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key(paciente_id) references pacientes(id)
);

## Inserir informações ma tabela Usuários
insert into usuarios values(1, 'fabio.batista@teste.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
insert into usuarios values(2, 'livia.batista@teste.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
insert into usuarios values(3, 'giovanna.batista@teste.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');

## Inserir informações ma tabela Médicos
INSERT INTO medicos
(id, nome, email, crm, especialidade, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(1, 'Kamilly Nair Maria Figueiredo', 'kamilly-figueiredo82@videoaction.com.br', '303030', 'CARDIOLOGIA', 'Rua Conrado Cruz', 'Urbanova', '12244530', '', '391', 'SP', 'São José dos Campos', '', 1);

INSERT INTO medicos
(id, nome, email, crm, especialidade, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(2, 'Camilly Nair Maria Figueiredo', 'severino-silva94@akaer.com.br', '405060', 'CARDIOLOGIA', 'Rua Quarenta e Sete', 'São Raimundo', '12244530', '', '657', 'SP', 'São Paulo', '', 1);

INSERT INTO medicos
(id, nome, email, crm, especialidade, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(3, 'Felipe Vinicius dos Santos', 'felipe_vinicius_dossantos@gsw.com.br', '345217', 'CARDIOLOGIA', 'Rua Bramante Buffoni', 'Ermelino Matarazzo', '12244530', '', '406', 'SP', 'São Paulo', '', 1);

INSERT INTO medicos
(id, nome, email, crm, especialidade, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(4, 'Andreia Daiane de Paula', 'andreia_depaula@br.gestant.com', '874512', 'DERMATOLOGIA', 'Rua Eça de Queirós', 'Panorama', '16013690', '', '606', 'SP', 'São Paulo', '', 1);

INSERT INTO medicos
(id, nome, email, crm, especialidade, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(5, 'Rayssa Emily Almeida', 'rayssaemilyalmeida@asproplastic.com.br', '456789', 'DERMATOLOGIA', 'Rua Major Alfredo Romão', 'Vila Clarice', '05177030', '', '768', 'SP', 'São Paulo', '(11) 99143-2852', 1);

## Inserir informações ma tabela Pacientes
INSERT INTO pacientes
(id, nome, email, cpf, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(2, 'Paulo Gonzaga Fernandes', 'bentoenzofernandes@mabeitex.com.br', '259.395.248-26', 'Rua Savério Fazzio', 'Jardim das Magnólias', '18044-610', '', '930', 'SP', 'Sorocaba', '(15) 98708-6536', 1);

INSERT INTO pacientes
(id, nome, email, cpf, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(3, 'Cláudio Cauê Thales Rodrigues', 'claudio_rodrigues@yaooh.com', '004.881.728-70', 'Rua Campos de Piratininga', 'Vila Ipê', '13044-320', '', '287', 'SP', 'Campinas', '(19) 98653-7200', 1);

INSERT INTO pacientes
(id, nome, email, cpf, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(4, 'Louise Lúcia das Neves', 'louiseluciadasneves@abcautoservice.net', '800.639.838-00', 'Rua Guilherme Sverzut', 'Conjunto Habitacional Antônio Nadaletto Mazzer', '14177-085', '', '398', 'SP', 'Sertãozinho', '(16) 99370-7385', 1);

INSERT INTO pacientes
(id, nome, email, cpf, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo)
VALUES(5, 'Sophia Antonella Assis', 'sophiaantonellaassis@sp.senac.com.br', '156.456.008-27', 'Rua Antônio Bete', 'Jardim Califórnia', '14177-085', '', '434', 'SP', 'Jundiaí', '(11) 99901-8642', 1);

## Inserir informações ma tabela Consultas
INSERT INTO consultas (medico_id, paciente_id, `data`) VALUES('1', '1', '2023-09-10 10:00:00');
INSERT INTO consultas (medico_id, paciente_id, `data`) VALUES('2', '2', '2023-09-10 11:00:00');
INSERT INTO consultas (medico_id, paciente_id, `data`) VALUES('1', '1', '2023-09-11 12:00:00');
INSERT INTO consultas (medico_id, paciente_id, `data`) VALUES('4', '3', '2023-09-12 09:00:00');
INSERT INTO consultas (medico_id, paciente_id, `data`) VALUES('3', '4', '2023-09-13 10:00:00');

