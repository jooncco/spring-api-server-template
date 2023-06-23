# spring-api-server-template
🐬 Spring api server example.
Example spring api server that will ease your pain, aiming to deliver best practice in product-level server.

## Get Started

### Docker (prepare local DB)

1. Install Docker

This sample api server connects to local MySql DB, which runs inside the docker container environment.
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

- `GET` /order/{id}
- `GET` /orders
- `POST` /order
- `PUT` /order/{id}
- `DELETE` /order/{id}

### Aspects

- SampleAspect

### Interceptors

- CorrelationInterceptor
- RequestHeaderInterceptor (for API Client)

### Configurations

- ArgumentResolverConfig
- FilterConfig
- InterceptorConfig
- SwaggerConfig

### Persistence Layer

- Flyway Migration Scripts
  - V0_0_1_0__create_order_table.sql
  - V0_0_1_100__insert_order_test_data.sql
- MyBatis @Mapper Interface
  - OrderRepository / Order.xml

### Etc.

- Filter
  - BaseFilter

- Controller Advice
  - GlobalExceptionHandler.java

- DTO Mappers
  - GetOrderDTOMapper
  - GetOrdersDTOMapper

## Test (Local)

Swagger UI: http://localhost:9001/swagger-ui/index.html

## Stack

- Spring Boot: spring-boot-starter-web v2.7.11
- Lombok: v1.18.26
- Flyway
- MyBatis
