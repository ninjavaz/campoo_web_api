FROM maven:3.6.0-jdk-13-alpine as builder

ARG WORK_DIR=/home/app

#Settings for maven
RUN mkdir /root/.m2/
COPY settings.xml /root/.m2/

COPY src ${WORK_DIR}/src
COPY pom.xml ${WORK_DIR}
RUN mvn -f ${WORK_DIR}/pom.xml dependency:go-offline
ENV MAVEN_OPTS=-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2
RUN mvn -f ${WORK_DIR}/pom.xml clean package -DskipTests


#Deploy container
FROM openjdk:13

#variables
ENV WORK_DIR /app
#ARG JAR_FILE=target/*.jar
ARG JAR_FILE=target/events-*.jar
ENV SVC_NAME events

COPY --from=builder /home/app/${JAR_FILE}  $WORK_DIR/$SVC_NAME.jar

#ENTRYPOINT java -jar $WORK_DIR/$SVC_NAME.jar

#ENTRYPOINT ["java","-jar","$WORK_DIR/$SVC_NAME.jar"]
ENTRYPOINT ["java","-jar","/app/events.jar"]

