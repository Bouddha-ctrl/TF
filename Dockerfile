FROM maven:3.6.0-jdk-11-slim AS build
VOLUME /tmp
WORKDIR $HOME

ADD pom.xml $HOME

RUN ["mvn", "--version"]
ADD . $HOME
RUN ["mvn", "install"]








