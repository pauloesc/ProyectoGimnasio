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

function ordenarElementos(){
	let criterio = document.getElementById("ordenarPor").value;
	//primero ordeno cuponeras
	var itemsCup = document.getElementById("resultadosCuponeras").children;
	itemsCup = Array.prototype.slice.call(itemsCup);
	
	switch(criterio) {
	  case "az":
	    itemsCup.sort(function(a, b){
    	return a.id.localeCompare(b.id);
		});
	    break;
	  case "za":
	    itemsCup.sort(function(a, b){
    	return a.id.localeCompare(b.id);
		}).reverse();
	    break;
	  case "new":
		itemsCup.sort(function(a, b){
    	return new Date(b.children[0].children[1].id) - new Date(a.children[0].children[1].id);
		});
	    break;
	  case "old":
	    itemsCup.sort(function(a, b){
    	return new Date(b.children[0].children[1].id) - new Date(a.children[0].children[1].id);
		}).reverse();
	  default:
	} 
	
	var parent = document.getElementById('resultadosCuponeras');
	parent.innerHTML = "";
	
	for(var i = 0; i < itemsCup.length; i++) {
    	parent.appendChild(itemsCup[i]);
	}
	
	//luego ordeno actividades
	var itemsAct = document.getElementById("resultadosActividades").children;
	itemsAct = Array.prototype.slice.call(itemsAct);
	
	switch(criterio) {
	  case "az":
	    itemsAct.sort(function(a, b){
    	return a.id.localeCompare(b.id);
		});
	    break;
	  case "za":
	    itemsAct.sort(function(a, b){
    	return a.id.localeCompare(b.id);
		}).reverse();
	    break;
	  case "new":
		itemsAct.sort(function(a, b){
    	return new Date(b.children[0].children[0].children[0].children[1].id) - new Date(a.children[0].children[0].children[0].children[1].id);
		});
	    break;
	  case "old":
		itemsAct.sort(function(a, b){
    	return new Date(b.children[0].children[0].children[0].children[1].id) - new Date(a.children[0].children[0].children[0].children[1].id);
		}).reverse();
	    break;
	  default:
	}
	
	var parent = document.getElementById('resultadosActividades');
	parent.innerHTML = "";
	
	for(var i = 0; i < itemsAct.length; i++) {
    	parent.appendChild(itemsAct[i]);
	}
}

function aplicarFiltros(){
	mostrarTodos();
	ordenarElementos();
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