FROM openjdk:17-jre-slim

# 메타데이터 라벨
LABEL maintainer="ahwkt46@gmail.com"
LABEL version="1.0"
LABEL description="Spring Boot Application with Java 17"

# 작업 디렉토리 설정
WORKDIR /app

# 시스템 업데이트 및 필요한 패키지 설치
RUN apt-get update && \
    apt-get install -y curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# 애플리케이션 사용자 생성 (보안)
RUN groupadd -r appuser && useradd -r -g appuser appuser

# 빌드된 JAR 파일 복사 (Gradle)
COPY --from=build /app/build/libs/*.jar app.jar

# Maven 사용 시
# COPY --from=build /app/target/*.jar app.jar

# 로그 디렉토리 생성
RUN mkdir -p /app/logs && chown -R appuser:appuser /app

# 애플리케이션 사용자로 전환
USER appuser

# 포트 노출
EXPOSE 8080

# JVM 옵션 설정 (환경변수로 제공)
ENV JAVA_OPTS="-Xms512m -Xmx1024m -Dspring.profiles.active=prod"

# 헬스체크 설정
#HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
#  CMD curl -f http://localhost:8080/actuator/health || exit 1

# 애플리케이션 실행
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]