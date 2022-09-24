#----
# Build stage
#----
FROM maven:3.6-jdk-11 as buildstage
# Copy only pom.xml of your projects and download dependencies
COPY pom.xml .
RUN mvn -B -f pom.xml dependency:go-offline
# Copy all other project files and build project
COPY . .
RUN mvn -B install

#----
# Final stage
#----
FROM java:11
COPY --from=buildstage ./target/*.war ./

FROM tomcat
COPY --from=buildstage /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]