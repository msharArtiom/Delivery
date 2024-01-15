FROM openjdk:17
CMD ["/.gradlew", "clean", "bootJar"]
COPY build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]