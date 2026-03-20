================================================================================
  ACCESSCONTROL - Sistema de Autenticação e Controlo de Acessos
  Versão: 1.0
  Autor:  Lucas Gonçalves
  Data:   2026-03-17
================================================================================

--------------------------------------------------------------------------------
  DESCRIÇÃO
--------------------------------------------------------------------------------

O AccessControl é um sistema de autenticação de utilizadores desenvolvido em
Java com interface gráfica Swing. O objetivo principal é garantir que apenas
utilizadores com credenciais válidas consigam aceder ao sistema.

O tratamento de erros é feito através de uma exceção personalizada chamada
DadosInvalidosException, garantindo respostas organizadas em cada cenário.

--------------------------------------------------------------------------------
  FUNCIONALIDADES
--------------------------------------------------------------------------------

  - Autenticação por username e password
  - Validação de campos vazios com exceção personalizada
  - Distinção entre utilizadores normais e administradores (isAdmin)
  - Mensagens de feedback ao utilizador (JOptionPane)
  - Interface gráfica em Java Swing (JFrame)
  - Ligação à base de dados MySQL via JDBC

--------------------------------------------------------------------------------
  ARQUITETURA (Three-Tier)
--------------------------------------------------------------------------------

  [ VIEW ]         Login.java / Main.java
                   Interface gráfica com Java Swing
                          |
                          v
  [ SERVICE ]      UtilizadorService.java
                   Validação e lógica de negócio
                          |
                          v
  [ PERSISTENCE ]  UtilizadorDAO.java / Conexao.java
                   Comunicação com a base de dados MySQL

--------------------------------------------------------------------------------
  ESTRUTURA DO PROJETO
--------------------------------------------------------------------------------

  AccessControl/
  |
  +-- src/
  |   |
  |   +-- exception/
  |   |     DadosInvalidosException.java   (Exceção personalizada)
  |   |
  |   +-- model/
  |   |     Pessoa.java                    (Classe base: id, nome)
  |   |     Utilizador.java                (Herda Pessoa: username, password, isAdmin)
  |   |     Perfil.java                    (Tipo de acesso do utilizador)
  |   |
  |   +-- persistence/
  |   |     Conexao.java                   (Ligação JDBC ao MySQL)
  |   |     UtilizadorDAO.java             (Operações SQL sobre Utilizador)
  |   |
  |   +-- service/
  |   |     UtilizadorService.java         (Lógica de autenticação)
  |   |
  |   +-- view/
  |         Login.java                     (Ecrã de login)
  |         Main.java                      (Janela de boas-vindas)
  |
  +-- test/
  |     TestePessoa.java                   (Testes da classe Pessoa)
  |
  +-- lib/
  |     mysql-connector-java-8.0.27.jar    (Driver JDBC MySQL)
  |
  +-- README.txt                           (Este ficheiro)

--------------------------------------------------------------------------------
  MODELAÇÃO DE CLASSES
--------------------------------------------------------------------------------

  Pessoa
    - id       : int
    - nome     : String

        ^
        | (herança)

  Utilizador
    - username : String
    - password : String
    - isAdmin  : boolean

  Perfil
    - id         : int
    - nomePerfil : String

--------------------------------------------------------------------------------
  TECNOLOGIAS UTILIZADAS
--------------------------------------------------------------------------------

  Linguagem        : Java (JDK 21)
  Interface        : Java Swing (JFrame)
  Base de Dados    : MySQL 8.x
  Ligação BD       : JDBC + MySQL Connector 8.0.27
  IDE              : NetBeans 15

--------------------------------------------------------------------------------
  CONFIGURAÇÃO DA BASE DE DADOS
--------------------------------------------------------------------------------

  Host             : 62.28.39.135
  Porta            : 3306
  Base de dados    : efa0125_08_projeto_java
  Utilizador       : efa0125_08

  Script de criação da tabela:

    CREATE TABLE utilizador (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(100) NOT NULL,
        is_admin BOOLEAN NOT NULL
    );

  Dados de teste:

    INSERT INTO utilizador (username, password, is_admin)
    VALUES ('admin', '123', 1),
	   ('lucas', 'lucas', 0);

--------------------------------------------------------------------------------
  FLUXO DE AUTENTICAÇÃO
--------------------------------------------------------------------------------

  1. O utilizador introduz o username e password na janela Login
  2. A View envia os dados para a camada Service
  3. O Service valida se os campos estão preenchidos
       -> Se vazios: lança DadosInvalidosException
  4. O DAO consulta a base de dados com as credenciais
       -> Se válidas:  devolve o objeto Utilizador autenticado
       -> Se inválidas: devolve null e mostra mensagem de aviso
  5. Login bem-sucedido: abre a janela Main e fecha o Login

--------------------------------------------------------------------------------
  TRATAMENTO DE ERROS
--------------------------------------------------------------------------------

  Campos vazios              -> DadosInvalidosException com mensagem
  Credenciais incorretas     -> JOptionPane de aviso ao utilizador
  Erro na base de dados      -> DadosInvalidosException (envolve SQLException)
  Input não numérico         -> InputMismatchException convertida para
                                DadosInvalidosException

--------------------------------------------------------------------------------
  COMO EXECUTAR
--------------------------------------------------------------------------------

  1. Abrir o projeto no NetBeans:
       File -> Open Project -> selecionar a pasta AccessControl

  2. Adicionar o driver MySQL às Libraries:
       Clicar com botão direito em Libraries -> Add JAR
       Selecionar: mysql-connector-java-8.0.27.jar

  3. Configurar a base de dados:
       Executar o script SQL indicado acima no MySQL

  4. Executar o projeto:
       Correr Main.java como ponto de entrada (F6 no NetBeans)

--------------------------------------------------------------------------------
  REQUISITOS
--------------------------------------------------------------------------------

  - JDK 21 ou superior
  - NetBeans IDE 15 ou superior
  - MySQL Server 8.x
  - mysql-connector-java-8.0.27.jar na pasta lib/

--------------------------------------------------------------------------------
  AUTOR
--------------------------------------------------------------------------------

  Nome         : Lucas Gonçalves
  GitHub       : https://github.com/Lukasuuu
  Curso        : Programador Informático Nível 4
  Instituição  : IEFP - Centro de Formação Profissional de Braga
  Ano          : 2026

--------------------------------------------------------------------------------
  NOTAS ACADÉMICAS
--------------------------------------------------------------------------------

  Este projeto foi desenvolvido no âmbito do curso de Programador Informático
  Nível 4 no IEFP Braga, aplicando os seguintes conceitos lecionados em aula:

    - Programação Orientada a Objetos (herança, encapsulamento)
    - Arquitetura em camadas (Three-Tier)
    - Exceções personalizadas (DadosInvalidosException)
    - Ligação a base de dados com JDBC
    - Interface gráfica com Java Swing

================================================================================
  FIM DO DOCUMENTO
================================================================================