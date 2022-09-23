FROM tomcat
COPY target/croissantshow-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8173
CMD ["catalina.sh", "run"]