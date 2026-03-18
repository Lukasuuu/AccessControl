-- ====================================================
--  SCRIPT SQL SIMPLES - Sistema AccessControl
-- ====================================================

-- Criar base de dados (caso ainda não exista)
CREATE DATABASE IF NOT EXISTS efa0125_08_projeto_java;

-- Usar a base de dados
USE efa0125_08_projeto_java;

-- =========================
-- TABELA PESSOA
-- =========================
CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- =========================
-- TABELA PERFIL
-- =========================
CREATE TABLE perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_perfil VARCHAR(50) NOT NULL
);

-- =========================
-- TABELA UTILIZADOR
-- =========================
CREATE TABLE utilizador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    is_admin BOOLEAN NOT NULL
);

-- =========================
-- DADOS DE PERFIL
-- =========================
INSERT INTO perfil (nome_perfil) VALUES
('Administrador'),
('Utilizador');

-- =========================
-- DADOS DE PESSOA
-- =========================
INSERT INTO pessoa (nome) VALUES
('Lucas Gonçalves'),
('Utilizador Teste');

-- =========================
-- DADOS DE UTILIZADOR
-- =========================
INSERT INTO utilizador (username, password, is_admin) VALUES
('admin', '123', 1),
('lucas', 'lucas', 0);