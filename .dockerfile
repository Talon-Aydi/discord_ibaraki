FROM maven:3.9-eclipse-temurin-21 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
# Copy the exact bot.jar created by your finalName configuration
COPY --from=build /app/target/ibaraki-1.0-SNAPSHOT.jar /app/ibaraki-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "ibaraki-1.0-SNAPSHOT.jar"]