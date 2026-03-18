FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/api-immediate-payment-service.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
