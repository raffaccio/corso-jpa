FROM tomcat:11-jdk21-temurin
ADD target/corso-jpa-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/corso-jpa.war
EXPOSE 8080
CMD ["catalina.sh", "run"]


