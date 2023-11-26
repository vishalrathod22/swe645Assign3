#define base docker image
FROM openjdk:17
EXPOSE 8080
ADD target/HW3-0.0.1-SNAPSHOT.jar HW3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "HW3-0.0.1-SNAPSHOT.jar"]