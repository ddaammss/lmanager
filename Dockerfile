# 빌드 스테이지
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app
COPY . .

RUN mkdir -p /app/uploads && chmod 755 /app/uploads

# Gradle 빌드 실행
RUN chmod +x ./gradlew && \
    ./gradlew build -x test

# 실행 스테이지  
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 빌드 스테이지에서 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

COPY ssl-certs/keystore.p12 /app/keystore.p12

EXPOSE 443

ENV JAVA_OPTS="-Xms512m -Xmx1024m -Dspring.profiles.active=prod"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]



