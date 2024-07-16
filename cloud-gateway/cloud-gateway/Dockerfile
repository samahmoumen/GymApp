FROM openjdk:21
EXPOSE 8091
COPY development-platform-sa123-master/cloud-gateway/cloud-gateway/target/cloud-gateway-0.0.1-SNAPSHOT.jar cloud-gateway.jar
ENTRYPOINT ["java", "-jar", "/cloud-gateway.jar"]
