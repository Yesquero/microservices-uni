FROM maven:3.8.3-openjdk-17 as build
COPY . /src
WORKDIR /src
RUN mvn package

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /src/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
