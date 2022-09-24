FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME
ADD pom.xml $HOME
RUN ["mvn", "--version"]

ADD src $HOME
RUN ["mvn", "package"]

ADD target/croissantshow-0.0.1-SNAPSHOT.war croissantshow.jar
ENTRYPOINT ["java", "-jar", "croissantshow.jar"]








