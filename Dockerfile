#pull base image
FROM openjdk:8-jdk-alpine

#copy hello world to docker image
ADD  build/libs/dockerdemo-0.0.1-SNAPSHOT.jar dockerdemo-0.0.1-SNAPSHOT.jar

#expose port 8085
EXPOSE 8085

#default command
CMD java -jar dockerdemo-0.0.1-SNAPSHOT.jar


