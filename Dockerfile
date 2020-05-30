#run commands:
#mvn clean install
#docker build --tag challenge-evoluum .
#docker run -p 8089:8080 challenge-evoluum

FROM openjdk:14.0.1-jdk as challenge-evoluum

MAINTAINER Rafael Salles <rafaelsalles.sistemas@gmail.com>

USER root

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} challenge-evoluum.jar
ENTRYPOINT ["java","-jar","/challenge-evoluum.jar"]