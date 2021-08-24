package controladores;

import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;
import logica.IctrlDeportivas;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import datatypes.DataActividad;
import datatypes.DataInstitucion;
import manejadores.manejDeportivas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controlador de Actividades e Instituciones Deportivas
 * @author mbarrera
 *
 */

public class ctrlDeportivas implements IctrlDeportivas{
	
	 public ctrlDeportivas() {
	 }

	public void altaInstitucion(String n, String de, String url) throws InstitucionDeportivaRepetidaException {
		manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva indep = mD.buscarInstitucion(n);
        if (indep != null)
            throw new InstitucionDeportivaRepetidaException("La institución deportiva " + n + " ya esta registrada.");

        indep = new InstitucionDeportiva(n, de, url);
        mD.agregarInstitucion(indep);
	}

	public void altaActividadDeportiva(String nid, String n, String de, Float dur, Float c, Date fal) throws ActividadDeportivaRepetidaException {
		manejDeportivas mD = manejDeportivas.getinstance();
        ActividadDeportiva actdep = mD.buscarActividad(n);
        if (actdep != null)
            throw new ActividadDeportivaRepetidaException("La actividad deportiva " + n + " ya esta registrada.");
		
        actdep = new ActividadDeportiva(n, de, dur, c, fal);
        mD.agregarActividad(actdep);
        InstitucionDeportiva indep = mD.buscarInstitucion(nid);
        indep.addActividadDeportiva(actdep);
	}

//	public void consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException {
		// TODO Auto-generated method stub
		
//	}
	
	public DataInstitucion[] getInstituciones() throws InstitucionDeportivaNoExisteException {
        manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva[] insdeps = mD.getInstituciones();

        if (insdeps != null) {
            DataInstitucion[] did = new DataInstitucion[insdeps.length];
            InstitucionDeportiva institucion;

            // Para separar lógica de presentación, no se deben devolver las Instituciones,
            // sino los DataInstitucion
            for (int i = 0; i < insdeps.length; i++) {
                institucion = insdeps[i];
                did[i] = new DataInstitucion(institucion.getNombre(), institucion.getDescripcion(), institucion.getURL());
            }

            return did;
        } else
            throw new InstitucionDeportivaNoExisteException("No existen Instituciones Deportivas registradas");

    }

	public DataActividad[] getActividades(String nid) throws ActividadDeportivaNoExisteException {
        manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva indep = mD.buscarInstitucion(nid);
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
		manejDeportivas mD = manejDeportivas.getinstance();
		ActividadDeportiva actividad = mD.buscarActividad(n);
		DataActividad dtact = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta());
		return dtact;	
	}

	public Set<String> darNombreInstituciones() {
		manejDeportivas mD = manejDeportivas.getinstance();
		return mD.darNombreInstituciones();
	}

	public Set<String> darNombresActividadesDeportivas(String inst) {
		manejDeportivas mD = manejDeportivas.getinstance();
		InstitucionDeportiva i = mD.buscarInstitucion(inst);
		
		return i.darNombresActividadesDeportivas();
	}

	public void cargarDatosDeportiva() {
		
		//cargo instituciones deportivas
		try {
			altaInstitucion("Instituto Natural", "Clases de gimnasia, aeróbica, spinning y yoga.", "https://www.inatural.com");
			altaInstitucion("Fuerza Bruta", "Gimnasio especializado en el desarrollo de la musculatura.", "https://www.musculos.com/");
			altaInstitucion("Telón", "Actividades deportivas para todas las edades.", "https://telon.com.uy");
			altaInstitucion("Olympic", "Gimnasia y Aparatos", "https://www.olympic21.com/");
		} catch (InstitucionDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date f1 = null, f2 = null, f3 = null, f4 = null, f5 = null, f6 = null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			f2 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			f3 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			f4 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			f5 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			f6 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//carto actividades deportivas
		try {
			altaActividadDeportiva("Fuerza Bruta", "Aparatos y pesas", "Clases de aparatos, pesas y calistenia.", 90f, 550f, f1);
			altaActividadDeportiva("Telón", "Voleibol", "Voleibol en todas sus formas.", 120f, 750f, f2);
			altaActividadDeportiva("Instituto Natural", "Aeróbica", "Para cuidar el aparato cardiovascular.", 110f, 800f, f3);
			altaActividadDeportiva("Fuerza Bruta", "Kickboxing ", "En busca del nuevo campeón de boxeo.", 100f, 980f, f4);
			altaActividadDeportiva("Telón", "Atletismo", "100m , 200m, postas y carreras con obstaculos.", 150f, 500f, f5);
			altaActividadDeportiva("Telón", "Basquetbol", "Espectáculo conmemorando los 30 años de Violeta. ", 80f, 450f, f6);
		} catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
