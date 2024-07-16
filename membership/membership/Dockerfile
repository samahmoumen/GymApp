FROM openjdk:21
EXPOSE 8089
COPY membership/membership/target/membership-0.0.1-SNAPSHOT.jar membership.jar
ENTRYPOINT ["java", "-jar", "/membership.jar"]
