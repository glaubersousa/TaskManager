# Task Manager API

## Descrição

O Task Manager API é uma aplicação RESTful desenvolvida em Java
utilizando o framework Spring Bot, com banco de dados em memória. 
Projeto que permite a gestão de tarefas, oferecendo funcionalidades 
para criação, leitura, atualização e
exclusão de tarefas.

## Funcionalidades

* **Gerenciamento de Tarefas:** 
  * **Criar Tarefas:** Adicione novas tarefas ao sistema com informações
  como título, descrição, data de criação, data de entrega, criador,
  responsável e status.
  * **Listar Tarefas:** Obter uma lista de todas as tarefas existentes.
  * **Atualizar Tarefas:** Modifique as informações de uma tarefa existente.
  * **Excluir Tarefas:** Remova tarefas do sistema.
  * **Buscar Tarefas:** Filtre as tarefas com base no status e ID.


* **Status das Tarefas:**
  * **PENDING** (Pendente)
  * **IN_PROGRESS** (Em progresso)
  * **COMPLETED** (Concluído)

## Tecnologias

* **Java:** Linguagem de programação.
* **Spring Boot:** Framework para construção da API.
* **H2 Database:** Banco de dados em memória para desenvolvimento e teste.
* **Maven:** Gerenciador de dependências e build system.

## Endpoints da API

### Listar Tarefas

* **URL:** '/tasks'
* **Método:** 'GET'

### Criar Tarefa

* **URL:** '/tasks'
* **Método:** 'POST'
* **Corpo da requisição:**
```json
{
  "title": "Título da Tarefa",
  "description": "Descrição da tarefa",
  "creationDate": "2024-08-13",
  "deliveryDate": "2024-08-20",
  "creator": "Nome do Criador",
  "responsible": "Nome do Responsável",
  "status": "PENDING"
}
```

### Atualizar Tarefa

* **URL:** '/tasks/{id}/update'
* **Método:** 'GET'
* **Corpo da Requisição:**
```json
{
  "title": "Título Atualizado",
  "description": "Descrição atualizada",
  "creationDate": "2024-08-13",
  "deliveryDate": "2024-08-20",
  "creator": "Nome do Criador",
  "responsible": "Nome do Responsável",
  "status": "IN_PROGRESS"
}
```

### Excluir Tarefa

* **URL:** '/tasks/{id}/delete'
* **Método:** 'DELETE'


