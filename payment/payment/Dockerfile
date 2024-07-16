FROM openjdk:21
EXPOSE 8080
COPY payment/payment/target/payment-0.0.1-SNAPSHOT.jar payment.jar
ENTRYPOINT ["java", "-jar", "/payment.jar"]
