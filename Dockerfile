FROM gradle:7.2.0-jdk17 AS build

WORKDIR /app
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle
RUN ./gradlew --no-daemon dependencies

RUN chmod +x ./gradlew

COPY src ./src
RUN ./gradlew --no-daemon bootJar

FROM openjdk:17-alpine


WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

# Expose port 8080 for the container
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]