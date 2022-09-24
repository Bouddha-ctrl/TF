FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME

ADD pom.xml $HOME
RUN ["mvn", "dependency:resolve"]
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
RUN ["mvn", "package"]
RUN ["mvn", "--version"]
ADD . $HOME
RUN ["mvn","clean","install","-T","2C","-DskipTests=true"]

ADD src /src



FROM openjdk:11
ADD target/croissantshow-0.0.1-SNAPSHOT.war croissantshow.jar
ENTRYPOINT ["java", "-jar", "croissantshow.jar"]