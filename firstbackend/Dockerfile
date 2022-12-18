FROM gradle:7-jdk17 as build
COPY . /src
WORKDIR /src
RUN gradle build

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /src/build/libs/*.jar /app/app.jar
COPY --from=build /src/build/otel/opentelemetry-javaagent.jar /app
EXPOSE 8081
ENV OTEL_SERVICE_NAME="first-backend"
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
