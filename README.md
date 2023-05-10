# spring-api-server-template
🐬 Spring api server example.
Provides opinionated view on server with sample code, showing best practices in real-world back-end micro services.

## Get Started

### Docker (prepare local DB)

1. Install Docker

Our sample api server connects to local MySql DB, which runs inside the docker container environment.
Make sure [Docker Desktop](https://docs.docker.com/engine/install/) is installed in your local environment.
```shell
docker ps
```

Possible alternative: [Rancher Desktop](https://docs.rancherdesktop.io/getting-started/installation/)

3. Create Docker Network

```shell
docker network create template-s-network
```

3. Docker Compose

```shell
docker compose up -d
```

You should see `template-s-network` in the list when you type `docker network ls`.

### Run

```shell
./gradlew bootRun
```

## Features

### REST APIs

- `POST` /order
- `GET` /order/{id}
- `PUT` /order/{id}
- `DELETE` /order/{id}
- `GET` /orders

### Aspects

- LogAspect

### Interceptors

- CorrelationInterceptor
- RequestHeaderInterceptor (for API Client)

### Configurations

- CorsConfig
- SwaggerConfig
- FeignClientConfig

### Persistence Layer

- Flyway Migration Scripts
  - V0_0_1_0__create_order_table.sql
  - V0_0_1_100__insert_order_test_data.sql
- MyBatis @Mapper Interface
  - OrderRepository / Order.xml
- JPA @Repository Interface
  - OrderRepository

### Etc.

- API Client (Open Feign)
  - PaymentApi
  - MemberApi
- Mock Servers
  - Payment Service Mock
  - Member Service Mock
- DTO Mappers

## Test

Swagger UI: http://localhost:9001/swagger-ui/index.html

## Stack

- Spring Boot: spring-boot-starter-web v3.0.5
- Lombok: v1.18.26
- Flyway
- MyBatis
- JPA
- Open Feign
