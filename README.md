# 📝 Yet Another Simple Task Manager (Spring Boot)

Um projeto básico desenvolvido com **Spring Boot** para gerenciar tarefas via **API REST**, permitindo criar, listar, atualizar e excluir tarefas no banco de dados **PostgreSQL**.

Este projeto foi criado com o objetivo de **aprender fundamentos do Spring Boot** como:
- Estrutura de camadas (Controller, Service, Repository)
- Spring Data JPA
- Validação de dados com Bean Validation
- Boas práticas de APIs REST
- Configuração de banco de dados no Spring

---

## 🚀 Funcionalidades

- **Criar tarefa** (`POST /tasks`)
- **Listar todas as tarefas** (`GET /tasks`)
- **Buscar tarefa por ID** (`GET /tasks/{id}`)
- **Atualizar tarefa** (`PUT /tasks/{id}`)
- **Excluir tarefa** (`DELETE /tasks/{id}`)
- **Validação de dados** com mensagens de erro amigáveis

---

## 📦 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot** (Web, Data JPA, Validation)
- **PostgreSQL**
- **Maven**
- **Hibernate**
- **Docker** (opcional, para banco de dados)
- 
---
## 📌 Próximos Passos

- Adicionar paginação e filtros

- Criar testes unitários

- Documentação da API com Swagger