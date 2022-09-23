#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.jar /usr/local/lib/croissantshow.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/croissantshow.war"]

FROM tomcat
COPY target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8173
CMD ["catalina.sh", "run"]