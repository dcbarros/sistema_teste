# Etapa de construção
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Executar os testes durante a construção
RUN mvn clean package || mvn surefire-report:report && exit 1

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
