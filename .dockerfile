FROM maven:3.9-eclipse-temurin-26 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:26-jre
WORKDIR /app
COPY --from=build /app/target/*-jar-with-dependencies.jar /app/bot.jar
CMD ["java", "-jar", "bot.jar"]

RUN echo "DISCORD_TOKEN=${DISCORD_TOKEN}" > .env && \
    echo "COMMAND_LISTENER_PATH=${COMMAND_LISTENER_PATH}" >> .env

CMD ["java", "-jar", "bot.jar"]