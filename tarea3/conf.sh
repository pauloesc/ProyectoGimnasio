#!/bin/bash

echo "Ubicando conf.properties"
cd ~
mkdir -p .entrenamosUy
cd .entrenamosUy
echo "Ingresar direccion IP del servidor: "
read var_ip
echo "Ingresar puerto del servicio: "
read var_port

echo "#para la web comun
urlADeportivas=http://$var_ip:$var_port/CtrlActDeportivas
urlCategorias=http://$var_ip:$var_port/ctrlCategorias
urlClases=http://$var_ip:$var_port/CtrlClases
urlUsuario=http://$var_ip:$var_port/ControladorUsuario
urlCuponeras=http://$var_ip:$var_port/CtrlCuponeras
urlIDeportivas=http://$var_ip:$var_port/ctrlInstituciones
#para la web comun
#para la webmovil
urlADeportivasWeb=http://$var_ip:$var_port/CtrlActDeportivas
urlCategoriasWeb=http://$var_ip:$var_port/ctrlCategorias
urlClasesWeb=http://$var_ip:$var_port/CtrlClases
urlUsuarioWeb=http://$var_ip:$var_port/ControladorUsuario
urlCuponerasWeb=http://$var_ip:$var_port/CtrlCuponeras
urlIDeportivasWeb=http://$var_ip:$var_port/ctrlInstituciones
#para la webmovil
#para la workStation
urlADeportivasWorkStation=http://$var_ip:$var_port/CtrlActDeportivas
urlCategoriasWorkStation=http://$var_ip:$var_port/ctrlCategorias
urlClasesWorkStation=http://$var_ip:$var_port/CtrlClases
urlUsuarioWorkStation=http://$var_ip:$var_port/ControladorUsuario
urlCuponerasWorkStation=http://$var_ip:$var_port/CtrlCuponeras
urlIDeportivasWorkStation=http://$var_ip:$var_port/ctrlInstituciones
#para la workStation" > conf.properties

cd /
mkdir -p entrenamosUy
cd entrenamosUy

echo "#para la web comun
urlADeportivas=http://$var_ip:$var_port/CtrlActDeportivas
urlCategorias=http://$var_ip:$var_port/ctrlCategorias
urlClases=http://$var_ip:$var_port/CtrlClases
urlUsuario=http://$var_ip:$var_port/ControladorUsuario
urlCuponeras=http://$var_ip:$var_port/CtrlCuponeras
urlIDeportivas=http://$var_ip:$var_port/ctrlInstituciones
#para la web comun
#para la webmovil
urlADeportivasWeb=http://$var_ip:$var_port/CtrlActDeportivas
urlCategoriasWeb=http://$var_ip:$var_port/ctrlCategorias
urlClasesWeb=http://$var_ip:$var_port/CtrlClases
urlUsuarioWeb=http://$var_ip:$var_port/ControladorUsuario
urlCuponerasWeb=http://$var_ip:$var_port/CtrlCuponeras
urlIDeportivasWeb=http://$var_ip:$var_port/ctrlInstituciones
#para la webmovil
#para la workStation
urlADeportivasWorkStation=http://$var_ip:$var_port/CtrlActDeportivas
urlCategoriasWorkStation=http://$var_ip:$var_port/ctrlCategorias
urlClasesWorkStation=http://$var_ip:$var_port/CtrlClases
urlUsuarioWorkStation=http://$var_ip:$var_port/ControladorUsuario
urlCuponerasWorkStation=http://$var_ip:$var_port/CtrlCuponeras
urlIDeportivasWorkStation=http://$var_ip:$var_port/ctrlInstituciones
#para la workStation" > conf.properties
