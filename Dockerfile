FROM openjdk:17.0-jdk-slim
ARG DEPENDENCY=target

COPY ${DEPENDENCY}/app-granja-api.jar /home/app-granja-api.jar

ENTRYPOINT   [ "java","-jar","-Dspring.profiles.active=release","/home/app-granja-api.jar" ]
