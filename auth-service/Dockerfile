FROM maven:3.8.5-openjdk-11 as build
COPY . /app/
WORKDIR /app
RUN mvn clean package -DskipTests

#RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar auth.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","auth.jar"]


