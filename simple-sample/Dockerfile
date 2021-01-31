FROM openjdk:15-jdk-slim AS builder
COPY App.java .
RUN javac App.java && jar cfe app.jar App App.class

FROM openjdk:15-slim
COPY --from=builder app.jar .
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
