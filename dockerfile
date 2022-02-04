FROM openjdk:8-jdk-alpine
MAINTAINER 'heavyflood@strato.co.kr'
ARG SERVER_ENV=dev
ENV SERVER_ENV ${SERVER_ENV}
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m -Xmx4g -Xms2g"
COPY ./msa.jar msa.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${SERVER_ENV}", "-jar","/msa.jar"]