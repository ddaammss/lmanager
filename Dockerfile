FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS="-Xms512m -Xmx1024m -Dspring.profiles.active=prod"

ENTRYPOINT ["java", "-jar", "app.jar"]