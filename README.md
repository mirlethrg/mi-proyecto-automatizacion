# api-scheduled-payment-service

## Requisitos
- Java 21
- Docker + Docker Compose

## Levantar infraestructura local (PostgreSQL)
```bash
docker compose -f infra/local/docker-compose.yml up -d
```

## Ejecutar servicio (perfil local)
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

## Swagger UI
Si esta habilitado springdoc, se expone en:
- `http://localhost:8080/swagger-ui.html`

## OpenAPI (contrato)
- `openapi/openapi.yaml`

## Migraciones (Liquibase)
- `liquibase/changelog.yaml`
- `liquibase/changesets/*` (crear tus propios changesets; el template no incluye ejemplos ejecutables)

## Tests
```bash
./mvnw test
```

## Coverage (JaCoCo)
```bash
./mvnw clean verify
```
- XML report: `target/site/jacoco/jacoco.xml`
- HTML report: `target/site/jacoco/index.html`

## Sonar local (opcional)
1. Levantar SonarQube local con el profile `sonar`:
```bash
docker compose -f infra/local/docker-compose.yml --profile sonar up -d
```
2. Generar token en `http://localhost:9000`.
3. Ejecutar analisis:
```bash
./mvnw clean verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=<TOKEN> -Dsonar.projectKey=api-scheduled-payment-service
```
