FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/farmacia-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "farmacia-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080