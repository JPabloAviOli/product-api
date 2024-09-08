FROM eclipse-temurin:17-alpine AS builder

WORKDIR /app

COPY ./pom.xml .
COPY ./mvnw .
COPY ./.mvn ./.mvn

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/api-product-0.0.1-SNAPSHOT.jar .

ENV PORT=8080

EXPOSE $PORT

CMD ["java", "-jar", "api-product-0.0.1-SNAPSHOT.jar"]