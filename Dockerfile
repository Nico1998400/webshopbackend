FROM maven:3.8.6-openjdk-18

WORKDIR ./

COPY ./ ./

RUN mvn package

CMD "java" "-jar" "./target/spring-boot-aws-exe.jar"