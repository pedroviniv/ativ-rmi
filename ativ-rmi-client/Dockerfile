FROM openjdk:8u131-jdk-alpine

ENV PROJECT_PATH /opt/ativ-rmi-client

COPY ./target/ativ-rmi-client.jar ${PROJECT_PATH}/ativ-rmi-client.jar

CMD ["java", "-jar", "/opt/ativ-rmi-client/ativ-rmi-client.jar"]