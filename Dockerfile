#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM tomcat
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8173
CMD ["catalina.sh", "run"]