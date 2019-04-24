FROM jboss/wildfly
ADD target/simpledemo.war /opt/jboss/wildfly/standalone/deployments/
