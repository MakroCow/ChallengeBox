# ChallengeBox

1. Install Wildfly 16.0.0 Final from [https://wildfly.org/downloads/](https://wildfly.org/downloads/) (extract the download to a preferred directory)
2. Download the modules.7z from Moodle and extract it. Merge the extracted directory with the 'modules' directory in your installation directory.
3. Im Installationsverzeichnis von Wildfly `/standalone/configuration/standalone.xml` unter Datasource 
`<datasource jta="true" jndi-name="java:jboss/datasources/challengeBox" pool-name="challengeBox" enabled="true" use-java-context="true">
                     <connection-url>jdbc:mysql://localhost:3306/challengeboxdb</connection-url>
                     <driver-class>com.mysql.jdbc.Driver</driver-class>
                     <driver>mysql</driver>
                     <security>
                         <user-name>root</user-name>
                         <password>root</password>
                     </security>
                 </datasource>` eintragen. 
                 Unter den Treibern noch `<driver name="mysql" module="com.mysql">
                                                                  <driver-class>com.mysql.jdbc.Driver</driver-class>
                                                                  <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
                                                              </driver>` eintragen.
4. Install MariaDB Server ([https://mariadb.com/downloads/](https://mariadb.com/downloads/))and start MariaDB (Windows: locate installation folder and run the ./bin/mysqld.exe)
5. Edit 'Run Configurations' to: 
- Application Server: JBoss 8.0.0.Final
- Open Browser: Use your favorite browser
- VM Options: --add-modules java.se
- JRE: Default 
- In dem Deployment-Tab die ChallengeBox.war hinzufügen
7. Start Wildfly: wilfly-installation-folder/bin/standalone.bat (Windows) or wilfly-installation-folder/bin/standalone.sh (Linux)