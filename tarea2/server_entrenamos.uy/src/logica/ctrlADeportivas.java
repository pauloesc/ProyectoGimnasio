package logica;

import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;

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

	public void altaActividadDeportiva(String nid, String pid, String n, String de, Float dur, Float c, Date fa, Set<String> cats) throws ActividadDeportivaRepetidaException {
		manejADeportivas mD = manejADeportivas.getinstance();
		manejIDeportivas mID = manejIDeportivas.getinstance();
		manejUsuarios mU = manejUsuarios.getInstance();
        ActividadDeportiva actdep = mD.buscarActividad(n);
        Profesor crea = mU.darProfesor(pid);
        
        if (actdep != null)
            throw new ActividadDeportivaRepetidaException("La actividad deportiva " + n + " ya esta registrada.");
        
        manejCategorias mC = manejCategorias.getInstance();
    	
        Map<String, Categoria> categorias = new HashMap<String, Categoria>();
        
        for (Iterator<String> it = cats.iterator(); it.hasNext();) { 
        	Categoria cat = mC.findCategoria(it.next());
        	if (cat != null)
        		categorias.put(cat.getNombre(), cat);	
    		}
        actdep = new ActividadDeportiva(n, crea, de, dur, c, fa, categorias);
        mD.agregarActividad(actdep); 
        
        if (crea != null)
        	crea.asociarseActividadDeportiva(actdep);
        
        InstitucionDeportiva indep = mID.buscarInstitucion(nid);
        indep.addActividadDeportiva(actdep);
	}

	public DataActividad[] getActividades(String nid) throws ActividadDeportivaNoExisteException {
        manejIDeportivas mID = manejIDeportivas.getinstance();
        InstitucionDeportiva indep = mID.buscarInstitucion(nid);
        ActividadDeportiva[] actsdeps = indep.getActividades();

        if (actsdeps != null) {
            DataActividad[] dad = new DataActividad[actsdeps.length];
            ActividadDeportiva actividad;

            // Para separar lógica de presentación, no se deben devolver las Actividades,
            // sino los DataActividad asociados a la Institución seleccionada.
            for (int i = 0; i < actsdeps.length; i++) {
                actividad = actsdeps[i];
                dad[i] = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta(), actividad.getEstado(), actividad.darCategorias(), actividad.getCreador().getNombre(), actividad.getCreador().getNombreInstitucion());
            }

            return dad;
        } else
            throw new ActividadDeportivaNoExisteException("No existen Actividades Deportivas en el sistema para la Institucón Deportiva seleccionada.");

    }

	public DataActividad getDataActividad(String n) throws ActividadDeportivaNoExisteException {
		manejADeportivas mD = manejADeportivas.getinstance();
		ActividadDeportiva actividad = mD.buscarActividad(n);
		String prof = "falta funcion";
		String inst = "falta funcion";
		DataActividad dtact = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta(), actividad.getEstado(), actividad.darCategorias(), prof, inst);
		return dtact;	
	}


	public Set<String> darNombresActividadesDeportivas(String inst) {
		manejIDeportivas mID = manejIDeportivas.getinstance();
		InstitucionDeportiva i = mID.buscarInstitucion(inst);
		
		return i.darNombresActividadesDeportivas();
	}
	
	public Set<String> mostrarClasesVigentesDeActividadDeportiva(String nomAct) {
		manejADeportivas mD = manejADeportivas.getinstance();
		ActividadDeportiva ac = mD.buscarActividad(nomAct);
		
		return ac.darNombreClasesVigentes();

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
	
	public void cambiarEstado(String n, EstadoActi est) {
		manejADeportivas mD = manejADeportivas.getinstance();
		ActividadDeportiva actividad = mD.buscarActividad(n);
		
		actividad.setEstado(est);
		
	}

	public void cargarDatosADeportivas() {
		
		manejADeportivas mD = manejADeportivas.getinstance();
		
		Set<String> c1 = new HashSet<String>();
		c1.add("Fitness");
		Set<String> c2 = new HashSet<String>();
		c2.add("Deportes");
		Set<String> c3 = new HashSet<String>();
		c3.add("Gimnasia");
		c3.add("Al aire libre");
		Set<String> c4 = new HashSet<String>();
		c4.add("Deportes");
		Set<String> c5 = new HashSet<String>();
		c5.add("Deportes");
		Set<String> c6 = new HashSet<String>();
		c6.add("Deportes");
		Set<String> c7 = new HashSet<String>();
		c7.add("Fitness");
		Set<String> c8 = new HashSet<String>();
		c8.add("Gimnasia");
	
		Date f1 = null, f2 = null, f3 = null, f4 = null, f5 = null, f6 = null, f7 = null, f8 = null, f9 = null, f10 = null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			f2 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			f3 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			f4 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			f5 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			f6 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			f7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			f8 = new SimpleDateFormat("dd/MM/yy").parse("30/08/21");
			f9 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			f10 = new SimpleDateFormat("dd/MM/yy").parse("07/09/21");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		//cargo actividades deportivas
		try {
			altaActividadDeportiva("Fuerza Bruta", "viktor" , "Aparatos y pesas", "Clases de aparatos, pesas y calistenia.", 90f, 550f, f1, c1);
			altaActividadDeportiva("Telon", "denis" , "Voleibol", "Voleibol en todas sus formas.", 120f, 750f, f2, c2);
			altaActividadDeportiva("Instituto Natural", null , "Aeróbica", "Para cuidar el aparato cardiovascular.", 110f, 800f, f3, c3);
			altaActividadDeportiva("Fuerza Bruta", "TheBoss" , "Kickboxing", "En busca del nuevo campeón de boxeo.", 100f, 980f, f4, c4);
			altaActividadDeportiva("Telon", "denis" , "Atletismo", "100m , 200m, postas y carreras con obstaculos.", 150f, 500f, f5, c5);
			altaActividadDeportiva("Telon", "Nelson" , "Basquetbol", "Basquetbol para todos.", 80f, 450f, f6, c6);
			altaActividadDeportiva("Fuerza Bruta", null , "Aparatos II", "Clases de aparatos avanzados", 60f, 1500f, f7, c7);
			altaActividadDeportiva("Instituto Natural", "clazar" , "Pilates", "El método Pilates combina diferentes capacidades físicas.", 45f, 600f, f8, c8);
			altaActividadDeportiva("Telon", "denis" , "Voleibol II", "Voleibol avanzado.", 120f, 1000f, f9, new HashSet<String>());
			altaActividadDeportiva("Telon", "denis" , "Basquetbol II", "Basquetbol avanzado.", 80f, 600f, f10, new HashSet<String>());
		} catch (ActividadDeportivaRepetidaException e) {
			//e.printStackTrace();
		}
		
		ActividadDeportiva a1 = mD.buscarActividad("Aparatos y pesas");
		a1.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva a2 = mD.buscarActividad("Voleibol");
		a2.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva a3 = mD.buscarActividad("Aeróbica");
		a3.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva a4 = mD.buscarActividad("Kickboxing");
		a4.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva a5 = mD.buscarActividad("Atletismo");
		a5.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva a6 = mD.buscarActividad("Basquetbol");
		a6.setEstado(EstadoActi.ACEPTADA);
		ActividadDeportiva a7 = mD.buscarActividad("Aparatos II");
		a7.setEstado(EstadoActi.RECHAZADA);
		ActividadDeportiva a9 = mD.buscarActividad("Voleibol II");
		a9.setEstado(EstadoActi.RECHAZADA);
	}

	@Override
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

}
