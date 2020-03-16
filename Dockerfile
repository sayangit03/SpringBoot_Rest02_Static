FROM openjdk:10
ADD target/BootRest01.jar BootRest01.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "BootRest01.jar"]