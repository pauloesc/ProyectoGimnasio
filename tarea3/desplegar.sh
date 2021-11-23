#!/bin/bash

echo "Desplegando sitios web..."
sudo systemctl stop tomcat
cp Gen/web/web.war /opt/tomcat/webapps/web.war
cp Gen/web/movil.war /opt/tomcat/webapps/movil.war
sudo systemctl start tomcat
echo "Finalizado"
