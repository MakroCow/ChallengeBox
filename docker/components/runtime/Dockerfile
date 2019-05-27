FROM jboss/wildfly AS runtime
COPY ./docker/module.xml /opt/jboss/wildfly/modules/com/mysql/main/
COPY ./docker/mysql-connector-java-8.0.16.jar /opt/jboss/wildfly/modules/com/mysql/main/
COPY ./docker/standalone-custom.xml /opt/jboss/wildfly/standalone/configuration
EXPOSE 8080
EXPOSE 9990
CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -c standalone-custom.xml