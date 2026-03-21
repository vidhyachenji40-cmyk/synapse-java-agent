# Use Java 21 (Matching your project)
FROM eclipse-temurin:21-jdk-jammy

# Set the folder inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the web port
EXPOSE 8080