FROM adoptopenjdk:11-jre-hotspot
MAINTAINER Jack Eastwood <imbakakak@gmail.com>

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]