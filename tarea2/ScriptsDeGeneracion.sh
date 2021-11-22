echo "Inicializando..."
rm -r Gen
mkdir Gen
mkdir Gen/web
mkdir Gen/sv

echo "Generando Website..."
cd website_entrenamos.uy
mvn clean compile install
cd ..
cp website_entrenamos.uy/target/website_entrenamos.uy.war Gen/web/website_entrenamos.uy.war

echo "Generando Websitemovil..."
cd websitemovil_entrenamos.uy
mvn clean compile install
cd ..
cp websitemovil_entrenamos.uy/target/websitemovil_entrenamos.uy.war Gen/web/websitemovil_entrenamos.uy.war

echo "Generando WorkStation..."
cd WorkStation
mvn clean compile install
cd ..
cp WorkStation/target/WorkStation.jar Gen/sv/WorkStation.jar
cp -r WorkStation/files/ Gen/sv/files/
cp WorkStation/conf.properties Gen/sv/conf.properties
echo "Finalizado"
