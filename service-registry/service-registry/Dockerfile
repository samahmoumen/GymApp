FROM openjdk:21
EXPOSE 8080
COPY service-registry/service-registry/target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
ENTRYPOINT ["java", "-jar", "/service-registry.jar"]
