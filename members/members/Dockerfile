FROM openjdk:21
EXPOSE 8092
COPY members/members/target/members-0.0.1-SNAPSHOT.jar members.jar
ENTRYPOINT ["java", "-jar", "/members.jar"]
