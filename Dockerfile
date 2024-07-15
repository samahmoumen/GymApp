FROM openjdk:21
EXPOSE 8080
ADD target/development-platform-sa123-master.jar development-platform-sa123-master.jar
ENTRYPOINT ["java","-jar", "/development-platform-sa123-master.jar"]