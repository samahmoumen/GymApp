FROM openjdk:21
EXPOSE 8080
COPY cloud-gateway/cloud-gateway/target/cloud-gateway-0.0.1-SNAPSHOT.jar cloud-gateway.jar
ENTRYPOINT ["java", "-jar", "/cloud-gateway.jar"]
