package logica;

import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controlador de Actividades Deportivas
 * @author mbarrera
 *
 */

public class ctrlADeportivas implements IctrlADeportivas{
	
	 public ctrlADeportivas() {
	 }

	public void altaActividadDeportiva(String nid, String n, String de, Float dur, Float c, Date fal) throws ActividadDeportivaRepetidaException {
		manejADeportivas mD = manejADeportivas.getinstance();
		manejIDeportivas mID = manejIDeportivas.getinstance();
        ActividadDeportiva actdep = mD.buscarActividad(n);
        if (actdep != null)
            throw new ActividadDeportivaRepetidaException("La actividad deportiva " + n + " ya esta registrada.");
		
        actdep = new ActividadDeportiva(n, de, dur, c, fal);
        mD.agregarActividad(actdep);
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
                dad[i] = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta());
            }

            return dad;
        } else
            throw new ActividadDeportivaNoExisteException("No existen Actividades Deportivas en el sistema para la Institucón Deportiva seleccionada.");

    }

	public DataActividad getDataActividad(String n) throws ActividadDeportivaNoExisteException {
		manejADeportivas mD = manejADeportivas.getinstance();
		ActividadDeportiva actividad = mD.buscarActividad(n);
		DataActividad dtact = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta());
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

	public void cargarDatosADeportivas() {
	
		Date f1 = null, f2 = null, f3 = null, f4 = null, f5 = null, f6 = null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			f2 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			f3 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			f4 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			f5 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			f6 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		//carto actividades deportivas
		try {
			altaActividadDeportiva("Fuerza Bruta", "Aparatos y pesas", "Clases de aparatos, pesas y calistenia.", 90f, 550f, f1);
			altaActividadDeportiva("Telón", "Voleibol", "Voleibol en todas sus formas.", 120f, 750f, f2);
			altaActividadDeportiva("Instituto Natural", "Aeróbica", "Para cuidar el aparato cardiovascular.", 110f, 800f, f3);
			altaActividadDeportiva("Fuerza Bruta", "Kickboxing", "En busca del nuevo campeón de boxeo.", 100f, 980f, f4);
			altaActividadDeportiva("Telón", "Atletismo", "100m , 200m, postas y carreras con obstaculos.", 150f, 500f, f5);
			altaActividadDeportiva("Telón", "Basquetbol", "Espectáculo conmemorando los 30 años de Violeta. ", 80f, 450f, f6);
		} catch (ActividadDeportivaRepetidaException e) {
			//e.printStackTrace();
		}
	}

}
