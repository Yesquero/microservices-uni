FROM maven:3.8.3-openjdk-17 as build
COPY . /src
WORKDIR /src
RUN mvn package

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /src/target/*.jar /app/app.jar
COPY --from=build /src/opentelemetry-javaagent.jar /app
EXPOSE 8081
ENV OTEL_SERVICE_NAME="first-backend"
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
