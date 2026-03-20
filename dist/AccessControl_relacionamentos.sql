-- ====================================================
--  SCRIPT SQL - AccessControl
--  Autor: Lucas Gonçalves
-- ====================================================
--
--  DIAGRAMA DAS RELAÇÕES:
--
--  pessoa (1) ────── (1) utilizador ────── (N) perfil
--
-- ====================================================

CREATE DATABASE IF NOT EXISTS efa0125_08_projeto_java;
USE efa0125_08_projeto_java;

-- ====================================================
-- Tabelas sem chaves estrangeiras primeiro
-- ====================================================

CREATE TABLE IF NOT EXISTS pessoa (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS perfil (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nome_perfil VARCHAR(50) NOT NULL
);

-- ====================================================
-- Tabela utilizador com as FKs
--
--  Obs: is_admin foi MANTIDO por mim, porque meu UtilizadorDAO.java usa diretamente na query de autenticação:
--  SELECT id, username, password, is_admin FROM utilizador
-- ====================================================

CREATE TABLE IF NOT EXISTS utilizador (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50)  NOT NULL,
    password  VARCHAR(100) NOT NULL,
    is_admin  BOOLEAN      NOT NULL,

    -- FK para pessoa: "Este utilizador É esta pessoa"
    -- reflete a herança Java: Utilizador extends Pessoa
    pessoa_id INT NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),

    -- FK para perfil: "Este utilizador TEM este perfil de acesso"
    perfil_id INT NOT NULL,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

-- ====================================================
-- Dados nas tabelas sem FK primeiro
-- ====================================================

INSERT INTO perfil (nome_perfil) VALUES
('Administrador'),  -- id = 1
('Utilizador');     -- id = 2

INSERT INTO pessoa (nome) VALUES
('Lucas Gonçalves'),  -- id = 1
('Utilizador Teste'); -- id = 2

-- ====================================================
-- Dados de utilizador com todos os IDs
--
--  admin → pessoa_id=1 (Lucas) | perfil_id=1 (Administrador) | is_admin=1
--  lucas → pessoa_id=2 (Teste) | perfil_id=2 (Utilizador)    | is_admin=0
-- ====================================================

INSERT INTO utilizador (username, password, is_admin, pessoa_id, perfil_id) VALUES
('admin', '123',   1, 1, 1),
('lucas', 'lucas', 0, 2, 2);
