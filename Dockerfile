# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the build output from the Gradle build context to the container's working directory
COPY build/libs/*.jar app.jar

# Expose port 8080 for the container
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]