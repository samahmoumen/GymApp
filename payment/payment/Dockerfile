FROM openjdk:21
EXPOSE 8090
COPY payment/payment/target/payment-0.0.1-SNAPSHOT.jar payment.jar
ENTRYPOINT ["java", "-jar", "/payment.jar"]
