FROM openjdk:11-slim-buster as build
COPY ./ ./

FROM tomcat
COPY --from=build /home/app/target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8173
CMD ["catalina.sh", "run"]