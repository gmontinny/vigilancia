# Stage 1: build usando Gradle com JDK 21
FROM gradle:8.6-jdk21 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
# constrói o JAR (remova -x test para rodar testes)
RUN ./gradlew clean bootJar -x test

# Stage 2: runtime com JRE 21
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]