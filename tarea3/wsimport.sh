#!/bin/bash

echo "Realizar wsimports"
echo "Ingresar direccion IP del servidor: "
read var_ip
echo "Ingresar puerto del servicio: "
read var_port

cd website_entrenamos.uy/src/main/java

wsimport -keep http://$var_ip:$var_port/CtrlActDeportivas?wsdl
wsimport -keep http://$var_ip:$var_port/ctrlCategorias?wsdl
wsimport -keep http://$var_ip:$var_port/CtrlClases?wsdl
wsimport -keep http://$var_ip:$var_port/ControladorUsuario?wsdl
wsimport -keep http://$var_ip:$var_port/CtrlCuponeras?wsdl
wsimport -keep http://$var_ip:$var_port/ctrlInstituciones?wsdl

cd ..
cd ..
cd ..
cd ..

cd websitemovil_entrenamos.uy/src/main/java

wsimport -keep http://$var_ip:$var_port/CtrlActDeportivas?wsdl
wsimport -keep http://$var_ip:$var_port/ctrlCategorias?wsdl
wsimport -keep http://$var_ip:$var_port/CtrlClases?wsdl
wsimport -keep http://$var_ip:$var_port/ControladorUsuario?wsdl
wsimport -keep http://$var_ip:$var_port/CtrlCuponeras?wsdl
wsimport -keep http://$var_ip:$var_port/ctrlInstituciones?wsdl

echo "Finalizado"
