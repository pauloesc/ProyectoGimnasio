echo "Inicializando..."
rm -r Gen
mkdir Gen
mkdir Gen/web
mkdir Gen/sv

echo "Generando Website..."
cd website_entrenamos.uy
mvn clean compile package
cd ..
cp website_entrenamos.uy/target/web.war Gen/web/web.war

echo "Generando Websitemovil..."
cd websitemovil_entrenamos.uy
mvn clean compile package
cd ..
cp websitemovil_entrenamos.uy/target/movil.war Gen/web/movil.war

echo "Generando WorkStation..."
cd WorkStation
mvn clean compile package
cd ..
cp WorkStation/target/servidor.jar Gen/sv/servidor.jar
cp -r WorkStation/target/.files/ Gen/sv/.files/
echo "Finalizado"
