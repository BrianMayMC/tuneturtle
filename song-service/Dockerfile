FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn package

FROM openjdk:17
COPY --from=build /usr/src/app/target/song-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
