<div align="left">
<h1 align="left">RestClientService</h1>
</div>

## Description:

Проект включает в себе Rest Api сервис, и базу  данных PostgreSQL. В качестве сборщика используется gradle. Проект можно склонировать и запустить в docker контейнере. Для отправки запросов использовался swagger. 


## Technologies:
* [Java 17](https://www.java.com/en/)
* [Spring 3.1.3](https://spring.io/)
* [PostgreSQL](https://www.postgresql.org/)
* [Docker](https://www.docker.com/)
* [Swagger](https://swagger.io/)
* [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org)

## Dependincies:
* [Java SE Development Kit 17+](https://www.oracle.com/java/technologies/downloads/archive/)
* [Docker](https://www.docker.com/)
* [Make](https://en.wikipedia.org/wiki/Make_(software))
* [Gradle](https://gradle.org)


### Installation
1. Находясь, в корне проекта, введите в терминале
   ```sh
   make (or "make all")
   ```
2. Для отправки запросов вы можете использовать Swagger, необходимо ввести в браузере:
   ```sh
   http://localhost:8080/swagger-ui/index.html
   ```
3. Чтобы остановить сервис:
   ```sh
   make stop
   ```
