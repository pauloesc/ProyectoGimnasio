package src.logica;

import java.util.Set;

import src.excepciones.ActividadDeportivaNoExisteException;
import src.excepciones.ActividadDeportivaRepetidaException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Controlador de Actividades Deportivas
 * @author mbarrera
 *
 */

public class ctrlADeportivas implements IctrlADeportivas{
	
	 public ctrlADeportivas() {
	 }

	public void altaActividadDeportiva(String nid, String pid, String nom, String des, Float dur, Float cos, Date falt, Set<String> cats, String img) throws ActividadDeportivaRepetidaException {
		manejADeportivas mADep = manejADeportivas.getinstance();
		manejIDeportivas mIDep = manejIDeportivas.getinstance();
		manejUsuarios mUsr = manejUsuarios.getInstance();
        ActividadDeportiva actdep = mADep.buscarActividad(nom);
        Profesor crea = mUsr.darProfesor(pid);
        
        if (actdep != null)
            throw new ActividadDeportivaRepetidaException("La actividad deportiva " + nom + " ya esta registrada.");
        
        manejCategorias mCat = manejCategorias.getInstance();
    	
        Map<String, Categoria> categorias = new HashMap<String, Categoria>();
        
        for (Iterator<String> it = cats.iterator(); it.hasNext();) { 
        	Categoria cat = mCat.findCategoria(it.next());
        	if (cat != null)
        		categorias.put(cat.getNombre(), cat);	
    		}
        actdep = new ActividadDeportiva(nom, crea, des, dur, cos, falt, categorias, img);
        mADep.agregarActividad(actdep); 
        
        if (crea != null)
        	crea.asociarseActividadDeportiva(actdep);
        
        InstitucionDeportiva indep = mIDep.buscarInstitucion(nid);
        indep.addActividadDeportiva(actdep);
	}

	public DataActividad[] getActividades(String nid) throws ActividadDeportivaNoExisteException {
        manejIDeportivas mID = manejIDeportivas.getinstance();
        InstitucionDeportiva indep = mID.buscarInstitucion(nid);
        ActividadDeportiva[] actsdeps = indep.getActividades();

        if (actsdeps != null) {
        	
            Set<DataActividad> dataActividades = new HashSet<DataActividad>();
            
            for (ActividadDeportiva act : actsdeps) {
            	if (act.getEstado() == EstadoActi.ACEPTADA)
            		dataActividades.add( getDataActividad(act.getNombre()) );
            }
            
            return dataActividades.toArray( new DataActividad[0] );
            
        } else
            throw new ActividadDeportivaNoExisteException("No existen Actividades Deportivas en el sistema para la Institucón Deportiva seleccionada.");

    }

	public DataActividad getDataActividad(String nom) throws ActividadDeportivaNoExisteException {
		manejADeportivas mDep = manejADeportivas.getinstance();
		ActividadDeportiva actividad = mDep.buscarActividad(nom);
		
		manejIDeportivas mID = manejIDeportivas.getinstance();
		InstitucionDeportiva[] instituciones = mID.getInstituciones();
		InstitucionDeportiva institucion;
		String inst = null;
		if (actividad != null) {
			
			for (int i = 0; i < instituciones.length; i++) {
                institucion = instituciones[i];
                Set<String> acts = institucion.darNombresActividadesDeportivastodas();
                if ( acts.contains(actividad.getNombre()) ) {
                	inst = institucion.getNombre();
                }
            }
			Profesor prof = actividad.getCreador();
			String nprof = null;
			if (prof != null) {
				nprof = prof.getNickname(); 
			}
			else {
				nprof = "Sin profesor asignado.";
			}
			DataActividad dtact = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta(), actividad.getEstado(), actividad.darCategorias(), nprof, inst, actividad.getImagen());
			return dtact;	
	 	} else
         throw new ActividadDeportivaNoExisteException("No existe la Actividad Deportiva.");
	}


	public Set<String> darNombresActividadesDeportivas(String inst) {
		manejIDeportivas mID = manejIDeportivas.getinstance();
		InstitucionDeportiva insti = mID.buscarInstitucion(inst);
		
		return insti.darNombresActividadesDeportivas();
	}
	
	public Set<String> mostrarClasesVigentesDeActividadDeportiva(String nomAct) {
		manejADeportivas mADep = manejADeportivas.getinstance();
		ActividadDeportiva act = mADep.buscarActividad(nomAct);
		
		return act.darNombreClasesVigentes();

    }
	
	public Set<String> getActividadesIngresadas() throws ActividadDeportivaNoExisteException {
        manejADeportivas mAD = manejADeportivas.getinstance();
        ActividadDeportiva[] actsdeps = mAD.getActividades();

        if (actsdeps != null) {
        	Set<String> dad = new HashSet<String>();
            ActividadDeportiva actividad;

            // Para separar lógica de presentación, no se deben devolver las Actividades,
            // sino los DataActividad asociados a la Institución seleccionada.
            for (int i = 0; i < actsdeps.length; i++) {
                actividad = actsdeps[i];
                if (actividad.getEstado() == EstadoActi.INGRESADA) 
                	dad.add(actividad.getNombre());
                }

            return dad;
        } else
            throw new ActividadDeportivaNoExisteException("No existen Actividades Deportivas en estado INGRESADA en el sistema.");

    }
	
	public Set<DataActividad> getDataActividadesIngresadas() throws ActividadDeportivaNoExisteException {
        manejADeportivas mAD = manejADeportivas.getinstance();
        ActividadDeportiva[] actsdeps = mAD.getActividades();

        if (actsdeps != null) {
        	Set<DataActividad> dad = new HashSet<DataActividad>();
            ActividadDeportiva actividad;

            // Para separar lógica de presentación, no se deben devolver las Actividades,
            // sino los DataActividad asociados a la Institución seleccionada.
            for (int i = 0; i < actsdeps.length; i++) {
                actividad = actsdeps[i];
                if (actividad.getEstado() == EstadoActi.ACEPTADA) 
                	dad.add(this.getDataActividad(actividad.getNombre()));
                }

            return dad;
        } else
            throw new ActividadDeportivaNoExisteException("No existen Actividades Deportivas en estado INGRESADA en el sistema.");

    }
	
	public void cambiarEstado(String nom, EstadoActi est) {
		manejADeportivas mADep = manejADeportivas.getinstance();
		ActividadDeportiva actividad = mADep.buscarActividad(nom);
		
		actividad.setEstado(est);
		
	}
	
	public  Set<DtClase> getTodasLasClases() {
		return manejADeportivas.getinstance().getTodasLasClases();	
	}

	public void cargarDatosADeportivas() {
		
		manejADeportivas mADep = manejADeportivas.getinstance();
		
		Set<String> cat1 = new HashSet<String>();
		cat1.add("Fitness");
		Set<String> cat2 = new HashSet<String>();
		cat2.add("Deportes");
		Set<String> cat3 = new HashSet<String>();
		cat3.add("Gimnasia");
		cat3.add("Al aire libre");
		Set<String> cat4 = new HashSet<String>();
		cat4.add("Deportes");
		Set<String> cat5 = new HashSet<String>();
		cat5.add("Deportes");
		Set<String> cat6 = new HashSet<String>();
		cat6.add("Deportes");
		Set<String> cat7 = new HashSet<String>();
		cat7.add("Fitness");
		Set<String> cat8 = new HashSet<String>();
		cat8.add("Gimnasia");
	
		Date fe1 = null, fe2 = null, fe3 = null, fe4 = null, fe5 = null, fe6 = null, fe7 = null, fe8 = null, fe9 = null, fe10 = null;
		try {
			fe1 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			fe2 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			fe3 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			fe4 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			fe5 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			fe6 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			fe7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			fe8 = new SimpleDateFormat("dd/MM/yy").parse("30/08/21");
			fe9 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			fe10 = new SimpleDateFormat("dd/MM/yy").parse("07/09/21");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		//cargo actividades deportivas
		try {
			altaActividadDeportiva("Fuerza Bruta", "viktor" , "Aparatos y pesas", "Clases de aparatos, pesas y calistenia.", 90f, 550f, fe1, cat1, "a1.jpg");
			altaActividadDeportiva("Telón", "denis" , "Voleibol", "Voleibol en todas sus formas.", 120f, 750f, fe2, cat2, "a2.jpg");
			altaActividadDeportiva("Instituto Natural", null , "Aeróbica", "Para cuidar el aparato cardiovascular.", 110f, 800f, fe3, cat3, "a3.jpg");
			altaActividadDeportiva("Fuerza Bruta", "TheBoss" , "Kickboxing", "En busca del nuevo campeón de boxeo.", 100f, 980f, fe4, cat4, "a4.jpg");
			altaActividadDeportiva("Telón", "denis" , "Atletismo", "100m , 200m, postas y carreras con obstaculos.", 150f, 500f, fe5, cat5, "a5.jpg");
			altaActividadDeportiva("Telón", "Nelson" , "Basquetbol", "Basquetbol para todos.", 80f, 450f, fe6, cat6, null);
			altaActividadDeportiva("Fuerza Bruta", null , "Aparatos II", "Clases de aparatos avanzados", 60f, 1500f, fe7, cat7, null);
			altaActividadDeportiva("Instituto Natural", "clazar" , "Pilates", "El método Pilates combina diferentes capacidades físicas.", 45f, 600f, fe8, cat8, "a8.jpg");
			altaActividadDeportiva("Telón", "denis" , "Voleibol II", "Voleibol avanzado.", 120f, 1000f, fe9, new HashSet<String>(), "a9.jpeg");
			altaActividadDeportiva("Telón", "denis" , "Basquetbol II", "Basquetbol avanzado.", 80f, 600f, fe10, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e) {
			//e.printStackTrace();
		}
		
		ActividadDeportiva act1 = mADep.buscarActividad("Aparatos y pesas");
		act1.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva act2 = mADep.buscarActividad("Voleibol");
		act2.setEstado(EstadoActi.FINALIZADA);
		ActividadDeportiva act3 = mADep.buscarActividad("Aeróbica");
		act3.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva act4 = mADep.buscarActividad("Kickboxing");
		act4.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva act5 = mADep.buscarActividad("Atletismo");
		act5.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva act6 = mADep.buscarActividad("Basquetbol");
		act6.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva act7 = mADep.buscarActividad("Aparatos II");
		act7.setEstado(EstadoActi.RECHAZADA);
		ActividadDeportiva act9 = mADep.buscarActividad("Voleibol II");
		act9.setEstado(EstadoActi.RECHAZADA);
	}

	
	public Set<String> getActividadesCategoria(String cat) {
		manejADeportivas mAD = manejADeportivas.getinstance();
		ActividadDeportiva[] actsdeps = mAD.getActividades();
		Set<String> dad = new HashSet<String>();
		
		if (actsdeps != null) {
            ActividadDeportiva actividad;
            Set<String> categorias = new HashSet<String>();

            for (int i = 0; i < actsdeps.length; i++) {
                actividad = actsdeps[i];
                categorias = actividad.darCategorias();
                if ( categorias.contains(cat) ) 
                	dad.add(actividad.getNombre());
            }     
        }
		return dad;
    }

	public Set<DataActividad> buscarActividades(String query) {
		manejADeportivas mAD = manejADeportivas.getinstance();
		ActividadDeportiva[] actsdeps = mAD.getActividades();
		Set<DataActividad> results = new HashSet<DataActividad>();
		
		for (ActividadDeportiva act : actsdeps) {
			if ( act.getEstado() == EstadoActi.ACEPTADA && (act.getNombre().toLowerCase().contains(query) ||
					act.getDescripcion().toLowerCase().contains(query) )) {
				try {
					results.add( getDataActividad(act.getNombre()) );
				}
				catch (ActividadDeportivaNoExisteException e) {
					return null;
				}
				
			}
		}
		return results;
	}

}
