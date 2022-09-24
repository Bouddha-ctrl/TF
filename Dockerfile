FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME
ADD pom.xml $HOME
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
ADD . $HOME
RUN ["mvn","clean","install","-T","2C","-DskipTests=true"]

FROM openjdk:11
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/lib/croissantshow.war
ADD target/croissantshow-0.0.1-SNAPSHOT.war croissantshow.jar
ENTRYPOINT ["java", "-jar", "croissantshow.jar"]