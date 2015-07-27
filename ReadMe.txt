Downloads :

 tomcat 	: https://tomcat.apache.org/download-70.cgi
 MySql 		: https://dev.mysql.com/downloads/mysql/
 My SQL connector JAR :  http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.36/mysql-connector-java-5.1.36.jar
 
Configuration :

Eclipse Config : 

Import the project into eclipse using "Import existing projects" option
Set the  JRE environment anything greater than Java 7_67
Set the build path to /ecommerce/WebContent/WEB-INF/lib

Database setup :
 
Install MYSQL server
Install MYSQL workbench
Run the scripts in /ecommerce/database/DB_Script.sql

Server config :

Extract the tomcat zip file
Place the my sql connector jar file in tomcat/lib folder


Execution:

Open eclipse, open projcet explorer
Right-click on project, say Run on server
It asks to configure the server, add the server configuration folder there.
Run on server.

Access the project in explorer via : http://localhost:8080/ecommerce
