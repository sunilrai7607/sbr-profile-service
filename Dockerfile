FROM openjdk:8-jdk-alpine
MAINTAINER Sunil Rai <sunilrai7607@gmail.com>
VOLUME /app
ARG version
ENV version_number=$version
COPY ./build/libs/sbr-profile-service-$version_number.jar sbr-profile-service.jar
ENTRYPOINT ["java", "-jar","/sbr-profile-service.jar"]