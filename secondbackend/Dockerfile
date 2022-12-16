FROM maven:3.8.3-openjdk-17

RUN mvn clean package

FROM amazoncorretto:17
VOLUME /tmp
ADD /target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
