FROM gradle:7.2.0-jdk17 AS build

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts gradlew ./
RUN chmod +x ./gradlew
COPY gradle ./gradle
RUN ./gradlew --no-daemon dependencies

COPY src ./src
RUN ./gradlew --no-daemon bootJar

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/farmacia-0.0.1-SNAPSHOT.jar farmacia-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "farmacia-0.0.1-SNAPSHOT.jar"]