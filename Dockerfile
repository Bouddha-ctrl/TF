FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME
RUN apt-get update
RUN apt-get install -y maven
ADD pom.xml $HOME
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
ADD . $HOME
RUN ["mvn","clean","install","-T","2C","-DskipTests=true"]
ADD src $HOME/src/
RUN ["mvn", "package"]


FROM openjdk:11
ADD target/croissantshow-0.0.1-SNAPSHOT.war croissantshow.jar
ENTRYPOINT ["java", "-jar", "croissantshow.jar"]