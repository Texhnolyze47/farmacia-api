FROM openjdk:17-jdk-slim
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app.jar"]