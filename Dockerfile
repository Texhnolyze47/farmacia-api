# Base image
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Final image
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]