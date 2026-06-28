FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
COPY --from=build /app/target/*-jar-with-dependencies.jar /app/bot.jar
WORKDIR /app
CMD ["java", "-jar", "bot.jar"]