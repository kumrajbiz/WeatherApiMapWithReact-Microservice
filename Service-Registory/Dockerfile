FROM openjdk:11
LABEL "Developer"="Rajesh kumar"
LABEL "Microservice"="Service registry "
WORKDIR /app
COPY ./src/main/resources/application.yml /app/config/
COPY target/A1Universal-ServiceRegistory-0.0.1-SNAPSHOT.jar A1Universal-ServiceRegistory-0.0.1-SNAPSHOT.jar
EXPOSE 8761
CMD ["java", "-jar", "A1Universal-ServiceRegistory-0.0.1-SNAPSHOT.jar"]