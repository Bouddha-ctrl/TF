FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/app
WORKDIR $HOME
ADD pom.xml $HOME
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
ADD . $HOME
RUN ["mvn","clean","install","-T","2C","-DskipTests=true"]

FROM tomcat
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8173
CMD ["catalina.sh", "run"]