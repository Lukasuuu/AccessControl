# 🔐 AccessControl

> Sistema de autenticação e controlo de acessos desenvolvido em Java com arquitetura em camadas.

---

## 📋 Descrição

O **AccessControl** é um sistema de autenticação de utilizadores desenvolvido em Java com interface gráfica Swing. O objetivo principal é garantir que apenas utilizadores com credenciais válidas consigam aceder ao sistema, com tratamento de erros organizado através de uma exceção personalizada.

---

## ✨ Funcionalidades

- Autenticação de utilizadores por **username** e **password**
- Validação de campos vazios com exceção personalizada (`DadosInvalidosException`)
- Distinção entre utilizadores **normais** e **administradores** (`isAdmin`)
- Mensagens de feedback ao utilizador em cada cenário de login
- Interface gráfica em **Java Swing (JFrame)**
- Ligação a base de dados **MySQL** via JDBC

---

## 🏗️ Arquitetura

O projeto segue a arquitetura em **três camadas (Three-Tier Architecture)**:

```
┌─────────────────────────────────────┐
│           VIEW (Interface)          │  ← Login.java / Main.java
│        Java Swing · JFrame          │
└──────────────────┬──────────────────┘
                   │
┌──────────────────▼──────────────────┐
│        SERVICE (Lógica negócio)     │  ← UtilizadorService.java
│     Validação · Regras de negócio   │
└──────────────────┬──────────────────┘
                   │
┌──────────────────▼──────────────────┐
│      PERSISTENCE (Base de dados)    │  ← UtilizadorDAO.java / Conexao.java
│          SQL · JDBC · MySQL         │
└─────────────────────────────────────┘
```

---

## 📁 Estrutura do Projeto

```
AccessControl/
├── src/
│   ├── exception/
│   │   └── DadosInvalidosException.java   # Exceção personalizada
│   ├── model/
│   │   ├── Pessoa.java                    # Classe base (id, nome)
│   │   ├── Utilizador.java                # Herda Pessoa (username, password, isAdmin)
│   │   └── Perfil.java                    # Tipo de acesso do utilizador
│   ├── persistence/
│   │   ├── Conexao.java                   # Ligação JDBC ao MySQL
│   │   └── UtilizadorDAO.java             # Operações SQL sobre Utilizador
│   ├── service/
│   │   └── UtilizadorService.java         # Lógica de autenticação
│   └── view/
│       ├── Login.java                     # Ecrã de login
│       └── Main.java                      # Janela principal de boas-vindas
└── test/
    └── teste/
        └── TestePessoa.java               # Testes da classe Pessoa
```

---

## 🧬 Modelação (UML simplificado)

```
Pessoa
├── id : int
└── nome : String

     ▲ (herança)

Utilizador
├── username : String
├── password : String
└── isAdmin : boolean

Perfil
├── id : int
└── nomePerfil : String
```

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Versão | Utilização |
|---|---|---|
| Java | JDK 21 | Linguagem principal |
| Java Swing | — | Interface gráfica (JFrame) |
| JDBC | — | Ligação à base de dados |
| MySQL | 8.x | Base de dados relacional |
| MySQL Connector | 8.0.27 | Driver JDBC |
| NetBeans IDE | 15 | Ambiente de desenvolvimento |

---

## 🗄️ Base de Dados

```sql
CREATE TABLE utilizador (
    id        INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(50)  NOT NULL,
    password  VARCHAR(50)  NOT NULL,
    is_admin  BOOLEAN      NOT NULL
);

-- Dados de teste
INSERT INTO utilizador (username, password, is_admin)
VALUES ('admin', '123', 1),
       ('lucas', 'lucas', 0);
```

**Configuração da ligação** (`Conexao.java`):

| Parâmetro | Valor |
|---|---|
| Host | 62.28.39.135 |
| Porta | 3306 |
| Base de dados | efa0125_08_projeto_java |
| Utilizador | efa0125_08 |

---

## 🔄 Fluxo de Autenticação

```
Utilizador introduz credenciais
           │
           ▼
    Login.java (View)
    Lê username e password
           │
           ▼
  UtilizadorService (Service)
  Valida se os campos estão preenchidos
  └─ Vazios → lança DadosInvalidosException
           │
           ▼
  UtilizadorDAO (Persistence)
  Consulta a base de dados MySQL
           │
     ┌─────┴──────┐
     ▼            ▼
Credenciais    Credenciais
  válidas       inválidas
     │            │
     ▼            ▼
Bem-vindo!   "Utilizador ou
Abre Main    password incorretos"
```

---

## 🚨 Tratamento de Erros

| Situação | Comportamento |
|---|---|
| Campos vazios | Lança `DadosInvalidosException` com mensagem |
| Credenciais erradas | Mostra `JOptionPane` de aviso |
| Erro na base de dados | `DadosInvalidosException` com detalhe do `SQLException` |
| Input inválido (ex: letra em campo numérico) | `InputMismatchException` convertida para `DadosInvalidosException` |

---

## 🚀 Como Executar

1. **Clonar o repositório**
```bash
git clone https://github.com/Lukasuuu/AccessControl.git
```

2. **Abrir no NetBeans** — File → Open Project → selecionar a pasta

3. **Adicionar o driver MySQL** — clicar com o botão direito em Libraries → Add JAR → `mysql-connector-java-8.0.27.jar`

4. **Configurar a base de dados** — executar o script SQL acima no MySQL

5. **Executar** — correr `Main.java` como ponto de entrada

---

## 👤 Autor

**Lucas Gonçalves**
- GitHub: [@Lukasuuu](https://github.com/Lukasuuu)
- Curso: Programador Informático Nível 4
- Instituição: IEFP – Centro de Formação Profissional de Braga
- Ano: 2026

---

## 📄 Licença

Este projeto foi desenvolvido para fins académicos no âmbito do curso de **Programador Informático Nível 4** no IEFP Braga.
