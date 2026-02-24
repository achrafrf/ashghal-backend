# المرحلة 1: بناء البروجي (Build)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# المرحلة 2: تشغيل البروجي (Run)
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Render كيعطي بورت أوتوماتيك، هاد السطر غير باش نعلموه
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]