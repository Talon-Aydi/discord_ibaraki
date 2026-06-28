FROM maven:3.9-eclipse-temurin-26 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:26-jre
COPY --from=build /app/target/*-jar-with-dependencies.jar /app/bot.jar
WORKDIR /app
CMD ["java", "-jar", "bot.jar"]