FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME

ADD pom.xml $HOME/pom.xml
RUN ["mvn", "--version"]

ADD src $HOME/src
RUN ["mvn", "install"]

ADD target/croissantshow-0.0.1-SNAPSHOT.war croissantshow.jar
ENTRYPOINT ["java", "-jar", "croissantshow.jar"]








