# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project's pom.xml and source code to the working directory
COPY pom.xml /app
COPY src /app/src

# Install Maven
RUN apt-get update && apt-get install -y maven

# Compile and package the application
RUN mvn package

# Specify the command to run the application
CMD ["java", "-cp", "target/java-functional-1.0-SNAPSHOT.jar", "com.example.Main"]
