mvn clean compile install
cd target
mkdir GEN
cp WorkStation.jar GEN/WorkStation.jar
cd ..
cp -r files/ target/GEN/files/
cp conf.properties target/GEN/conf.properties
cd target/GEN
echo "Ejecutando..."
java -jar WorkStation.jar
