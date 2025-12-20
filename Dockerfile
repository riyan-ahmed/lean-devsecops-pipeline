# Runtime image only (build happens in CI)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Create a non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy the built JAR
COPY target/myapp.jar app.jar

# Drop privileges
USER appuser

ENTRYPOINT ["java","-jar","app.jar"]
