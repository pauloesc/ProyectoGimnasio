#!/bin/bash
echo "Por favor, ingresa la ruta (con / al final) donde esta el servidor Tomcat"
read destino
sudo "${destino}bin/shutdown.sh"
cp Gen/web/web.war "${destino}webapps/"
cp Gen/web/movil.war "${destino}webapps/"
sudo "${destino}bin/startup.sh"
echo "Finalizado"
