FROM dockerfile

ADD /build/libs/spring-boot-learning-1.0-SNAPSHOT.jar /opt/spring-boot-learning-docker/

EXPOSE 8080

WORKDIR /opt/spring-boot-learning-docker/

CMD ["java", "-jar", "spring-boot-learning-1.0-SNAPSHOT.jar"]