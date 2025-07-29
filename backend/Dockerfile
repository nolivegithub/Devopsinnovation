# ---- Build stage ----
    FROM maven:3.9.6-eclipse-temurin-17 AS builder
    WORKDIR /app
    
    # Copy the parent pom.xml
    COPY pom.xml ./pom.xml
    
    # Copy only the backend module
    COPY backend ./backend
    
    # Build only the backend module, with parent pom now in place
    RUN mvn -pl backend -am clean package -DskipTests
    
    # ---- Run stage ----
    FROM eclipse-temurin:17-jdk
    WORKDIR /app
    
    # Copy the built JAR from the builder stage
    COPY --from=builder /app/backend/target/*.jar app.jar
    
    EXPOSE 8080
    ENTRYPOINT ["java", "-jar", "app.jar"]
    