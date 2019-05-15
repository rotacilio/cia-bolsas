FROM maven:3.5.4-jdk-10-slim

RUN mkdir /usr/src/app
WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn -Dmaven.test.skip=true package

RUN cp /usr/src/app/target/CiaDasBolsas-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]