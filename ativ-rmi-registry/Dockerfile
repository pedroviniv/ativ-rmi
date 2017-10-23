FROM openjdk:8u131-jdk-alpine

ENV PROJECT_PATH /opt/ativ-rmi-registry

COPY ./target/ativ-rmi-registry.jar ${PROJECT_PATH}/ativ-rmi-registry.jar

CMD ["java", "-jar", "/opt/ativ-rmi-registry/ativ-rmi-registry.jar"]