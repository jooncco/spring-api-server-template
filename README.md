# spring-api-server-template-async
🐬 Spring api server example.

## Get Started

### Docker (prepare local DB)

1. Install Docker

Our sample api server connects to local MySql DB, which runs inside the docker container environment.  
Make sure [Docker Desktop](https://docs.docker.com/engine/install/) is installed in your local PC.

Possible alternative: [Rancher Desktop](https://docs.rancherdesktop.io/getting-started/installation/)  

2. Create Docker Network

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

- `GET` /orders
- `POST` /order
- `PUT` /order
- `DELETE` /order

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
  - v0_0_1_1__create_order_table.sql
  - v0_0_1_2__insert_order_data.sql
- MyBatis @Mapper Interface
  - OrderRepository / Order.xml
- JPA @Repository Interface
  - OrderRepository

### API Client (Open Feign)

- PaymentApi
- MemberApi

### Mock Servers

- Payment Service Mock
- Member Service Mock

## Stack

- Spring Boot: spring-boot-starter-web v3.0.5
- Lombok: v1.18.26
- Flyway
- MyBatis
- JPA
- Open Feign