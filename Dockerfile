FROM amazoncorretto:21-alpine

USER root

# Set the timezone
RUN echo "America/Santiago" > /etc/timezone

RUN apk add --update \
    curl \
    gcompat \
    && rm -rf /var/cache/apk/*

ENV LD_PRELOAD=/lib/libgcompat.so.0

# Copy app target
COPY target/*.jar /home/userapp/app.jar

# Copy app resources
RUN mkdir /home/userapp/config
COPY src/main/resources/config/application.properties /home/userapp/config/application.properties
COPY src/main/resources/logback-cloud.xml /home/userapp/logback-cloud.xml
COPY src/main/resources/logback-local.xml /home/userapp/logback-local.xml
COPY src/main/resources/i18n /home/userapp/i18n

RUN addgroup -S app && adduser -S -G app app \
 && mkdir -p /home/userapp/logs \
 && chown -R app:app /home/userapp

WORKDIR /home/userapp

# Set non-root user
USER app

# Set health check
HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1",

# Configures the container to be run as an executable
ENTRYPOINT ["java","-jar","app.jar"]