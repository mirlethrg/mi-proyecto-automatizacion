# Automated Testing & Quality Gate Framework

A Senior-level automation engine for validating complex payment systems, ensuring contract compliance, security hardening, and performance standards.

## Tech Stack
- **Language:** Java 21
- **Framework:** Spring Boot 3.x
- **Testing:** JUnit 5, Karate DSL, Playwright
- **Analysis:** JaCoCo (Coverage), SonarQube (Quality)
- **Infra:** Docker & Docker Compose

## Core Features
- **Contract Testing:** Automated validation against OpenAPI 3.1 specifications.
- **Security Gates:** Sanitization checks and vulnerability scanning integrated into CI.
- **Performance Benchmarking:** SLA validation (< 3s response time).
- **High Coverage:** Minimum 80% test coverage requirement.

## Getting Started

### Local Infrastructure (PostgreSQL)
```bash
docker compose -f infra/local/docker-compose.yml up -d
```

### Run Service (Local Profile)
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

### Documentation (Swagger UI)
Accessible at: `http://localhost:8080/swagger-ui.html`

## Testing & Quality

### Run Unit & Integration Tests
```bash
./mvnw test
```

### Generate Coverage Report
```bash
./mvnw clean verify
```
Reports are available at `target/site/jacoco/index.html`.

### Static Analysis (Local)
1. Start SonarQube:
```bash
docker compose -f infra/local/docker-compose.yml --profile sonar up -d
```
2. Run analysis:
```bash
./mvnw clean verify sonar:sonar -Dsonar.projectKey=qa-automation-engine
```

## CI/CD
This project is configured with **GitHub Actions** for continuous integration and automated quality gates.
