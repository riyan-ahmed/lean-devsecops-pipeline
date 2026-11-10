# Build stage: full JDK, only used to compile; never shipped
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /workspace

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN chmod +x mvnw \
    && ./mvnw -B dependency:go-offline

COPY src/ src/

RUN ./mvnw -B clean package

# Runtime stage: JRE-only Alpine image (no compiler, no apt, no curl)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN addgroup -S spring && adduser -S -G spring spring

COPY --from=build --chown=spring:spring \
    /workspace/target/myapp.jar app.jar

USER spring:spring

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=5s --start-period=20s --retries=3 \
    CMD wget -q -O /dev/null http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
