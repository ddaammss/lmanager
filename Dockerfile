FROM openjdk:17-jre-slim

WORKDIR /app

COPY /app/build/libs/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS="-Xms512m -Xmx1024m -Dspring.profiles.active=prod"

ENTRYPOINT ["java", "-jar", "app.jar"]