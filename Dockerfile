FROM gradle:6.7.0-jdk11

EXPOSE 8099

COPY ./ ./
 
RUN gradle build

CMD ["java", "-jar", "./build/libs/favorites-0.0.1-SNAPSHOT.jar"]
