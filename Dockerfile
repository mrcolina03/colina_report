# java 17
FROM eclipse-temurin:17-jdk-alpine

LABEL authors="mrcolina"

WORKDIR /app

# Copiar el jar al contenedor
COPY ./target/colina_report-0.0.1-SNAPSHOT.jar ./test-0.0.1-SNAPSHOT.jar

# Puerto de exposición
EXPOSE 8082

ENTRYPOINT ["java", "-jar", "test-0.0.1-SNAPSHOT.jar"]