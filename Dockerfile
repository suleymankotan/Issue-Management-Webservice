FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/issue-management-0.0.1.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/app.jar"]