FROM maven:3.8.7-amazoncorretto-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:11-al2-full
WORKDIR /app
COPY --from=build ./app/target/**.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]