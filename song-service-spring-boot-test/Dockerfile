# FROM openjdk:17
# ADD target/song-service-spring-boot-test-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:17
WORKDIR /app
COPY target/song-service-spring-boot-test-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties /app/application.properties
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
