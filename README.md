# ChallengeBox

1. Install Wildfly from Auch Repository (Ver 16.0.0). 
2. Download modules.7z from Moodle. In the Wildfly directory: Merge the modules directory with the modules directory extracted from modules.7z
2. Install MariaDB (use default username: "root" and password "root") and start MariaDB (locate installation folder and run the mysqld.exe or ./bin/standalone.sh or ./bin/standalone.bat)
3. Edit 'Run Configurations' to: 
- Application Server: JBoss 8.0.0.Final
- Open Browser: Use your favorite browser
- VM Options: --add-modules java.se
- JRE: Default