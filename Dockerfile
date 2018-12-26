#pull base image
FROM openjdk:8-jdk-alpine
FROM jenkins/jenkins

#copy hello world to docker image
ADD  build/libs/dockerdemo-0.0.1-SNAPSHOT.war dockerdemo-0.0.1-SNAPSHOT.war

#expose port 8085
EXPOSE 8085

#default command
CMD java -jar dockerdemo-0.0.1-SNAPSHOT.war


