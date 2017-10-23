FROM openjdk:8u131-jdk-alpine

ENV PROJECT_PATH /opt/ativ-rmi-server

COPY ./target/ativ-rmi-server.jar ${PROJECT_PATH}/ativ-rmi-server.jar

CMD ["java", "-jar", "/opt/ativ-rmi-server/ativ-rmi-server.jar"]