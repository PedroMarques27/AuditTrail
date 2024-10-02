# Use an OpenJDK image as the base
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/audittrail-0.0.1-SNAPSHOT.jar /app/audittrail.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "audittrail.jar"]
