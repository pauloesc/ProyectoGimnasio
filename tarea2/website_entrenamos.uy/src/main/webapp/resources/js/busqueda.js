function mostrarTodos(){
	var divsToShow = document.getElementsByClassName("resultado"); 
    for(var i = 0; i < divsToShow.length; i++){
        divsToShow[i].style.display = ""; 
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

function aplicarFiltros(){
	mostrarTodos();
	var divsToHide = document.getElementsByClassName("resultado");
	let filtroCategoria = document.getElementById("categoriasFiltro");
	let cats = filtroCategoria.selectedOptions;
	if (cats.lenght != 0) {
		for(var i = 0; i < cats.length; i++){
			for(var j = 0; j < divsToHide.length; j++){
				if ( !divsToHide[j].classList.contains(cats[i].value) )
        			divsToHide[j].style.display = "none"; 
    		}
		}
	}
	let filtroInstitucion = document.getElementById("institucionesFiltro");
	let inst = filtroInstitucion.selectedOptions;
	if (inst.lenght != 0) {
		for(var i = 0; i < inst.length; i++){
			for(var j = 0; j < divsToHide.length; j++){
				if ( !divsToHide[j].classList.contains(inst[i].value) )
        			divsToHide[j].style.display = "none"; 
    		}
		}
	}
}