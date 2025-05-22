# Desafio Itaú - Backend

Este projeto é uma solução para o desafio técnico proposto pelo Itaú Unibanco, com foco em desenvolvimento de uma API REST utilizando Java com Spring Boot.

## Descrição do Desafio

A aplicação expõe uma API REST com três endpoints principais:

`POST /transacao`: Recebe uma transação financeira.

`GET /estatistica`: Retorna estatísticas das transações dos últimos 60 segundos.

`DELETE /transacao`: Remove todas as transações.

Todas as transações são armazenadas em memória, sem uso de banco de dados ou sistemas de cache.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven
- Docker

## Requisitos de negócios

- Apenas transações com data e hora nos últimos 60 segundos são consideradas nas estatísticas.
- Transações com valor negativo ou com data futura são rejeitadas.
- As estatísticas incluem: soma, média, máximo, mínimo e quantidade.

## 🐳 Executando com Docker

docker build -t desafio-itau-java21 .

docker run -p 8080:8080 desafio-itau-java21

A API estará disponível em: http://localhost:8080

## Link para desafio

https://github.com/feltex/desafio-itau-backend
