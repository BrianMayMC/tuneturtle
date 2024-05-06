FROM openjdk:17
WORKDIR /app
COPY target/TestRestProject-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties /app/application.properties
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "app.jar"]
