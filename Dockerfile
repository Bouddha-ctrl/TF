FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME

ADD pom.xml $HOME
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
RUN ["mvn", "package"]
RUN ["mvn", "--version"]
ADD . $HOME
RUN ["mvn","clean","install","-T","2C","-DskipTests=true"]







