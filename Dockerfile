FROM openjdk:17-jdk-slim

WORKDIR /app


COPY gradle/wrapper/gradle-wrapper.jar ./gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.properties ./gradle/wrapper/

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

COPY src ./src

RUN ./gradlew build --no-daemon

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/farmacia-0.0.1-SNAPSHOT.jar"]