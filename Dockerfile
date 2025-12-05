# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN apk add --no-cache maven
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Convert DATABASE_URL to JDBC format
ENTRYPOINT sh -c 'export JDBC_DATABASE_URL=$(echo $DATABASE_URL | sed "s/^postgres:/jdbc:postgresql:/") && java -jar app.jar'