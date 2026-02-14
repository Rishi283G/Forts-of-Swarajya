# Multi-stage build for Forts of Swarajya Spring Boot Application

# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy dependency files first for better caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Create non-root user for security
RUN groupadd -r fortuser && useradd -r -g fortuser fortuser

# Copy the built JAR from build stage
COPY --from=build /app/target/FortsOfSwarajya-0.0.1-SNAPSHOT.jar app.jar

# Change ownership to non-root user
RUN chown -R fortuser:fortuser /app

# Switch to non-root user
USER fortuser

# Expose the application port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]

