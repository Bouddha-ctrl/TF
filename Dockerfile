########build stage########
FROM maven:3.5-jdk-11 as maven_build
WORKDIR /app

COPY pom.xml .
# To resolve dependencies in a safe way (no re-download when the source code changes)
RUN mvn clean package -Dmaven.main.skip -Dmaven.test.skip && rm -r target

# To package the application
COPY src ./src
RUN mvn clean package -Dmaven.test.skip

########run stage########
FROM java:11
WORKDIR /app
COPY --from=maven_build /app/target/*.war

#run the app
#ENV JAVA_OPTS ""
#CMD [ "bash", "-c", "java ${JAVA_OPTS} -jar *.jar -v"]

FROM tomcat
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]