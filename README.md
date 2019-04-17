# ChallengeBox

1. Install Wildfly 16.0.0 Final from [https://wildfly.org/downloads/](https://wildfly.org/downloads/) (extract the download to a preferred directory)
2. Download the modules.7z from Moodle and extract it. Merge the extracted directory with the 'modules' directory in your installation directory.
3. Install MariaDB Server ([https://mariadb.com/downloads/](https://mariadb.com/downloads/))and start MariaDB (Windows: locate installation folder and run the ./bin/mysqld.exe)
4. Edit 'Run Configurations' to: 
- Application Server: JBoss 8.0.0.Final
- Open Browser: Use your favorite browser
- VM Options: --add-modules java.se
- JRE: Default 
5. Start Wildfly: wilfly-installation-folder/bin/standalone.bat (Windows) or wilfly-installation-folder/bin/standalone.sh (Linux)