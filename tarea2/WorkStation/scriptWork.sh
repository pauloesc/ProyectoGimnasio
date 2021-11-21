mvn clean compile install
cd target
mkdir GEN
cp WorkStation-0.0.1-SNAPSHOT.jar GEN/WorkStation-0.0.1-SNAPSHOT.jar
cd ..
cp -r files/ target/GEN/files/
cp conf.properties target/GEN/conf.properties
cd target/GEN
echo "Ejecutando..."
java -jar WorkStation-0.0.1-SNAPSHOT.jar
