FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY /build/libs/CurrencyRateGif-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","CurrencyRateGif-0.0.1-SNAPSHOT.jar"]