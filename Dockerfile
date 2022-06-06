FROM openjdk:8-jdk-alpine
MAINTAINER jatinder
COPY target/covid-19-app-1.0.0.jar covid-19-app-1.0.0.jar
ENTRYPOINT ["java","-jar","/covid-19-app-1.0.0.jar"]