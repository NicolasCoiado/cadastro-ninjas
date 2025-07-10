# 🥷 Cadastro de Ninjas - API RESTful com Spring Boot

Projeto desenvolvido durante o curso **Java10x** utilizando o framework **Spring Boot**.  
Esta aplicação é uma **API RESTful** que realiza operações de **CRUD** (Create, Read, Update e Delete) para cadastro de **Ninjas** e **Missões**, inspirados no universo **Naruto**.

O projeto segue uma **arquitetura em camadas** (`Controller`, `Service`, `Repository`, `Model`, `DTO`, `Mapper`), com boas práticas de separação de responsabilidades, documentação com **Swagger** e versionamento de banco de dados com **Flyway**.

---

## 🚀 Tecnologias e Ferramentas Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Flyway** – versionamento de banco de dados
- **Lombok** – redução de boilerplate
- **Swagger/OpenAPI 3** – documentação interativa da API
- **dotenv** – configuração de variáveis de ambiente
- **Maven** – gerenciamento de dependências

---

## 🔧 Configuração e Execução

### Pré-requisitos

- Java 21 ou superior
- Maven instalado

### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:

```env
DATABASE_URL={{ex: jdbc:h2:mem:ninjasdb}}
DATABASE_USERNAME={{ex: juninho}}
DATABASE_PASSWORD={{super_senha123}}
```

> A aplicação utiliza **banco de dados H2 em memória** por padrão, o que dispensa instalação de banco externo.

### application.properties (configurado para usar variáveis do `.env`)

```properties
spring.application.name=CadastroDeNinjas

spring.datasource.url=${DATABASE_URL}
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migrations
spring.flyway.baseline-on-migrate=true
```

### Executando o projeto

```bash
./mvnw spring-boot:run
```

> Acesse o console H2 (opcional):  
> `http://localhost:8080/h2-console`  

---

## 📚 Documentação da API

A documentação Swagger está disponível em:

```
http://localhost:8080/swagger-ui/index.html
```

### 🧑‍🎓 Rotas para Ninjas

| Método | Endpoint               | Descrição                           |
|--------|------------------------|-------------------------------------|
| GET    | `/ninjas/listar`       | Lista todos os ninjas               |
| GET    | `/ninjas/listar/{id}`  | Lista ninja por ID                  |
| POST   | `/ninjas/criar`        | Cria novo ninja                     |
| PUT    | `/ninjas/alterar/{id}` | Atualiza dados de um ninja          |
| DELETE | `/ninjas/deletar/{id}` | Exclui ninja por ID                 |

### 🎯 Rotas para Missões

| Método | Endpoint                 | Descrição                          |
|--------|--------------------------|------------------------------------|
| GET    | `/missoes/listar`        | Lista todas as missões             |
| GET    | `/missoes/listar/{id}`   | Lista missão por ID                |
| POST   | `/missoes/criar`         | Cria nova missão                   |
| PUT    | `/missoes/alterar/{id}`  | Atualiza dados de uma missão       |
| DELETE | `/missoes/deletar/{id}`  | Exclui missão por ID               |

---

## 💡 Possíveis Melhorias Futuras

- Implementar Spring Security.
- Dockerizar a Aplicação.
- Migrar para um banco de dados MySQL.
- Realizar Testes Unitários.
