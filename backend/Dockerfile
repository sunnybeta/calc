FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
EXPOSE 8080
COPY . .
RUN ./mvnw clean package
RUN cp target/*.jar app.jar
CMD ["java","-jar","app.jar"]
