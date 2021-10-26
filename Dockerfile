# 
# BUILD STAGE
#
FROM maven:3.6.0-jdk-11-slim AS build
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
RUN mvn -B dependency:resolve dependency:resolve-plugins
COPY /src /build/src
RUN mvn clean package -DskipTests

#
# REGISTRY STAGE
#
FROM openjdk:11-jre-slim AS deploy
COPY --from=build /build/target/*.jar sponsorship.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sponsorship.jar"]