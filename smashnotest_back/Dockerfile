# Stage 1 : build aplication
FROM eclipse-temurin:21-jdk AS builder
# Set working directori
WORKDIR /app
# Copy app code
COPY . .
# Build aplication (maven o gradle) (Skipeamos test unitarios)
# RUN ./mvnw clean package -DskipTests
RUN ./smashnotest_back/mvnw clean package -DskipTests



# Stage 2 : Run the aplication
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the war file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]



