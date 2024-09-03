FROM openjdk:17

WORKDIR /app

COPY target/courses-backend.jar /app/courses-backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/courses-backend.jar"]


