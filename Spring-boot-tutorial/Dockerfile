From maven:3.6.3-openjdk-11-slim as Builder
ARG version=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

run mvn clean package
COPY target/Spring-boot-tutorial-${version}.jar target/application.jar

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

COPY --from=Builder /build/target/application.jar /app/
CMD java -jar /app/application.jar