FROM maven:3.3-jdk-8 AS builder
COPY ./ /usr/src/mymaven
WORKDIR /usr/src/mymaven
RUN mvn clean install

FROM jboss/wildfly AS deployer
ENV THIS_REPO_ROOT ../../..
COPY ./docker/module.xml /opt/jboss/wildfly/modules/com/mysql/main/
COPY ./docker/mysql-connector-java-8.0.16.jar /opt/jboss/wildfly/modules/com/mysql/main/
COPY ./docker/standalone-custom.xml /opt/jboss/wildfly/standalone/configuration/
COPY --from=builder /usr/src/mymaven/target/deployments/challengeBox.war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080
EXPOSE 9990
CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -c standalone-custom.xml