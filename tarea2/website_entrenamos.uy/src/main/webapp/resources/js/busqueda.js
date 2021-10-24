function ocultarTodos(){
	var divsToHide = document.getElementsByClassName("resultado"); 
    for(var i = 0; i < divsToHide.length; i++){
        divsToHide[i].style.display = "none"; 
    }
}

function removerFiltros(){
	var divsToHide = document.getElementsByClassName("resultado"); 
    for(var i = 0; i < divsToHide.length; i++){
        divsToHide[i].style.display = ""; 
    }
	let filtroCategoria = document.getElementById("categoriasFiltro");
	filtroCategoria.selectedIndex = -1;
	let filtroInstitucion = document.getElementById("institucionesFiltro");
	filtroInstitucion.selectedIndex = -1;
}

function mostrarCategoriasSeleccionadas(categorias){
	for(var i = 0; i < categorias.length; i++){
        var divsToShow = document.getElementsByClassName(categorias[i].textContent); 
    	for(var j = 0; j < divsToShow.length; j++){
        	divsToShow[j].style.display = ""; 
   		}
    } 
}

function mostrarInstitucionesSeleccionadas(instituciones){
	for(var i = 0; i < instituciones.length; i++){
        var divsToShow = document.getElementsByClassName(instituciones[i].textContent); 
    	for(var j = 0; j < divsToShow.length; j++){
        	divsToShow[j].style.display = ""; 
   		}
    } 
}

function aplicarFiltros(){
	ocultarTodos();
	let filtroCategoria = document.getElementById("categoriasFiltro");
	let cats = filtroCategoria.selectedOptions;
	if (cats.lenght != 0) {
		mostrarCategoriasSeleccionadas(cats);
	}
	let filtroInstitucion = document.getElementById("institucionesFiltro");
	let inst = filtroInstitucion.selectedOptions;
	if (inst.lenght != 0) {
		mostrarInstitucionesSeleccionadas(inst);
	}
}