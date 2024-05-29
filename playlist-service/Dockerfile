FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /usr/src/app
COPY . .
ARG MONGODB_URL
RUN mvn package -Dmongodb.url=$MONGODB_URL -DskipTests

FROM openjdk:17
ENV MONGODB_URL mongodb://mongo:27017/
COPY --from=build /usr/src/app/target/playlist-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
