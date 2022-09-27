FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME
VOLUME /tmp

COPY pom.xml $HOME/pom.xml


COPY src $HOME/src
RUN mvn package


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","target/croissantshow-0.0.1-SNAPSHOT.jar"]