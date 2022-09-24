FROM openjdk:11-slim-buster as build
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw -B package
FROM openjdk:11-jre-slim-buster
COPY --from=build target/fast-maven-builds-1.0.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fast-maven-builds-1.0.jar"]

FROM tomcat
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8173
CMD ["catalina.sh", "run"]