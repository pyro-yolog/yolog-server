FROM eclipse-temurin:17-jdk-jammy AS build
ARG JAR_FILE=build/libs/yolog-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN chmod +x app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
