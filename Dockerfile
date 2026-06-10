FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/triangle-app-1.0.0.jar /app/triangle-app.jar
ENTRYPOINT ["java", "-jar", "/app/triangle-app.jar"]
