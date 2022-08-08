FROM maven:3-eclipse-temurin-18
WORKDIR /tmp
COPY /src/ ./src
COPY /pom.xml ./
RUN mvn package
EXPOSE 8080
CMD ["java","-Xmx1024m", "-jar", "/tmp/target/devops-fatjar.jar"]
