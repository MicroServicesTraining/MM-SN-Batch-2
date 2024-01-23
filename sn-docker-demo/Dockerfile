FROM openjdk:21-ea-14-jdk-slim

EXPOSE 8090:8090

WORKDIR /docker-imgs

COPY ./target/dockdemo.jar /dockdemo.jar

# java -jar dockdemo.jar - to run our application

ENTRYPOINT ["java", "-jar", "/dockdemo.jar"]