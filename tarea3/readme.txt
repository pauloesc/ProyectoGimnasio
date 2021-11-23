Primero ejecutar conf.sh, ingresando IP del pc host y puerto. Este coloca conf.properties con los valores asignados en el home.
Segundo ejecutar wsimport.sh, ingresando misma IP y puerto. Este actualiza los publicadores y proxys de los sitios web.
Tercero ejecutar scriptgen.sh. Este genera el jar y los war utilizando Maven.
Cuarto ejecutar desplegar.sh. Este carga al servidor web local en la VM los sitios web y movil.
Quinto llevar la carpeta files y el .jar al pc host (para distribuir el sistema en 2 equipos) y ejecutar el servidor.jar
Sexto cargar datos de prueba y utlizar el sistema <3
