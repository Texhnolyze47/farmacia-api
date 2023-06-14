# Package stage
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files to the container
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle/wrapper/gradle-wrapper.jar ./gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.properties ./gradle/wrapper/
COPY gradlew .

# Copy the entire source code to the container
COPY src ./src

# Run the Gradle build to download dependencies and build the application
RUN ./gradlew build --no-daemon

# Expose the port on which your Spring Boot application is listening
EXPOSE 8080
# Set the entry point command for the container
ENTRYPOINT ["java", "-jar", "build/libs/farmacia-0.0.1-SNAPSHOT.jar"]