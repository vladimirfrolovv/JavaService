FROM openjdk:17-alpine
ARG JARFILE=build/libs/RestClientService-0.0.1-SNAPSHOT.jar
COPY $JARFILE RestClientService.jar
EXPOSE 8080
CMD ["java", "-jar", "RestClientService.jar"]