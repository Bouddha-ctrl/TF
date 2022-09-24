FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME

ADD pom.xml $HOME
RUN ["mvn", "verify"]
RUN ["mvn", "--version"]
ADD . $HOME
RUN ["mvn", "package"]








