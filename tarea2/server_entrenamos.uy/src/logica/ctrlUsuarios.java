/**
 * 
 */
package logica;

import java.util.Set;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import excepciones.UsuarioDisponibilidadException;

public class ctrlUsuarios implements IctrlUsuarios {
	
	private manejUsuarios manejador;
	
	public ctrlUsuarios() {
		this.manejador = manejUsuarios.getInstance();
	}
	
	public Set<String> mostrarNombreProfesoresDeInstitucion(String inst) {
		return this.manejador.mostrarNombreProfesoresDeInstitucion(inst);
	}

	//paulo
	public void altaUsuario(InfoBasicaUser user) throws UsuarioDisponibilidadException {
		
		//cuando se crea el controlador ya ahi se trae el manejador  
		try{
			this.manejador.CrearUsuario(user);
		}catch(UsuarioDisponibilidadException e){
			throw e;
		}
		
	}
	

	public Vector<String> InstitucionesEnSistema() {
		
		manejIDeportivas mID = manejIDeportivas.getinstance();
		Set<String> set;
		set = mID.darNombreInstituciones();
		Iterator<String> iterate_value = set.iterator();
		
		Vector<String> vector = new Vector<String>();
		
		while(iterate_value.hasNext()){
			
			String e = iterate_value.next().toString();
			vector.add(e);
		}
		
		return vector;
		
	}
	
	public InformacionActividad InformacionActividad(String usuario) {
		
		return this.manejador.InformacionActividad(usuario);

	}
	
	public void ActualizarInformacionUsuario(InfoBasicaUser actualizacion){
		this.manejador.ActualizarInformacionUsuario(actualizacion);
		
	}
	
	public InfoBasicaUser InformacionBasicaUsuario(String usuario) {
		
		return this.manejador.InformacionBasicaUsuario(usuario);		
	}
	
	public Vector<String> UsuariosEnSistemaNickName(){
		
		return this.manejador.usuariosNickName();
		
	}
	//paulo
	
	
	public Set<String> MostrarCuponerasDisponibles(String nick, String actDept) {
		Socio s = (Socio) manejador.findUsuario(nick);
		
		return s.mostrarNombreCuponerasDisponibles(actDept); 
	}
	
	public Set<String> mostrarNicknameSocios() {
		return manejador.mostrarNicknameSocios();
	}
	
	public void cargarUsuarios() {
		//socios
		Date f1 = null, f2 = null, f3 = null, f4 = null, f5 = null, f6 = null, f7 = null, f8 = null, f9 = null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("31/12/1971");
			f2 = new SimpleDateFormat("dd/MM/yy").parse("15/11/1983");
			f3 = new SimpleDateFormat("dd/MM/yy").parse("15/04/1990");
			f4 = new SimpleDateFormat("dd/MM/yy").parse("15/05/1959");
			f5 = new SimpleDateFormat("dd/MM/yy").parse("28/01/1950");
			f6 = new SimpleDateFormat("dd/MM/yy").parse("17/03/1976");
			f7 = new SimpleDateFormat("dd/MM/yy").parse("14/02/1955");
			f8 = new SimpleDateFormat("dd/MM/yy").parse("23/02/1987");
			f9 = new SimpleDateFormat("dd/MM/yy").parse("08/05/1937");
			
			InfoBasicaSocio u1 = new InfoBasicaSocio("Emi71","Emiliano","Lucas","emi71@gmail.com",f1);
			InfoBasicaSocio u2 = new InfoBasicaSocio("caro","Carolina","Omega","caro@gmail.com",f2);
			InfoBasicaSocio u3 = new InfoBasicaSocio("euge","Eugenia","Williams","e.will@gmail.com",f3);
			InfoBasicaSocio u4 = new InfoBasicaSocio("guille","Guillermo","Hector","ghector@gmail.com",f4);
			InfoBasicaSocio u5 = new InfoBasicaSocio("sergiop","Sergio","Perez","sergi@gmail.com.uy",f5);
			InfoBasicaSocio u6 = new InfoBasicaSocio("andy","Andrés","Roman","chino@gmail.org.uy",f6);
			InfoBasicaSocio u7 = new InfoBasicaSocio("tonyp","Antonio","Paz","eltony@gmail.org.uy",f7);
			InfoBasicaSocio u8 = new InfoBasicaSocio("m1k4","Micaela","Lopez","mika@gmail.com.ar",f8);
			InfoBasicaSocio u9 = new InfoBasicaSocio("charly","Carlos","Boston","charly@gmail.com.uy",f9);
			
			manejador.CrearUsuario(u1);
			manejador.CrearUsuario(u2);
			manejador.CrearUsuario(u3);
			manejador.CrearUsuario(u4);
			manejador.CrearUsuario(u5);
			manejador.CrearUsuario(u6);
			manejador.CrearUsuario(u7);
			manejador.CrearUsuario(u8);
			manejador.CrearUsuario(u9);
	
		} catch (Exception e) {	
		}
		
		
		//Profesores
		Date pf1 = null, pf2 = null, pf3 = null, pf4 = null, pf5 = null, pf6 = null, pf7 = null, pf8 = null, pf9 = null;
		try {
			pf1 = new SimpleDateFormat("dd/MM/yy").parse("01/01/1977");
			pf2 = new SimpleDateFormat("dd/MM/yy").parse("14/06/1980");
			pf3 = new SimpleDateFormat("dd/MM/yy").parse("22/06/1953");
			pf4 = new SimpleDateFormat("dd/MM/yy").parse("23/09/1949");
			pf5 = new SimpleDateFormat("dd/MM/yy").parse("01/01/1998");
			pf6 = new SimpleDateFormat("dd/MM/yy").parse("14/02/1987");
			pf7 = new SimpleDateFormat("dd/MM/yy").parse("13/08/1981");
			pf8 = new SimpleDateFormat("dd/MM/yy").parse("05/03/1940");
			pf9 = new SimpleDateFormat("dd/MM/yy").parse("17/07/1952");
			
			InfoBasicaProfesor p1 = new InfoBasicaProfesor("viktor","Victor","Perez","vperez@fuerza.com",pf1,"Fuerza Bruta","Victor es un apasionado de los músculos. Sus clases son organizadas en función de distintos aparatos y pesas con el objetivo de desarrollar músculos","Victor nació en Moscow en 1977. En el año 2005 emigró a Uruguay luego de quedar encantado con el país en un viaje turístico","www.vikgym.com");
			InfoBasicaProfesor p2 = new InfoBasicaProfesor("denis","Denis","Miguel","den80@fuerza.com",pf2,"Telón","A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball","Denis fue un jugador de voleibol profesional.","www.depecho.com");
			InfoBasicaProfesor p3 = new InfoBasicaProfesor("clazar","Carlos","Lazaro","claz4r0@hotmail.com",pf3,"Instituto Natural","Carlos es un profesor muy divertido cuyas clases de aeróbica están cargadas de energía.","El interés por la actividad física llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.","www.enforma.com");
			InfoBasicaProfesor p4 = new InfoBasicaProfesor("TheBoss","Bruno","Sosa","bruceTheBoss@gmail.com",pf4,"Fuerza Bruta","Bruno es un ex-boxeardor que busca entrenar a futuros campeones.","Bruno, mejor conocido como Bruce en el ring, compitió como boxeador entre los años 60s y 70s.","www.bruce.net");
			InfoBasicaProfesor p5 = new InfoBasicaProfesor("Nelson","Luis","Nelson","nelson@hotmail.com",pf5,"Telón","Profesor de natación. Especializado en braza y mariposa.","","www.nelson.uy");
			InfoBasicaProfesor p6 = new InfoBasicaProfesor("lale","Laura","Leyes","la_le@outlook.com",pf6,"Telón","Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a enseñar tácticas de futbol","Jugadora profesional de futbol desde 2010 a 2020.","www.laley.com");
			InfoBasicaProfesor p7 = new InfoBasicaProfesor("prisc","Priscila","Pappo","pripa@gmail.com",pf7,"Olympic","Laura tiene un gran interés por los deportes olímpicos.","","www.pi314.net");
			InfoBasicaProfesor p8 = new InfoBasicaProfesor("dagost","Daiana","Agostini","d_1940_ago@gmail.com",pf8,"Olympic","Profesora dedicada y exigente. No acepta un “no puedo” como respuesta.","","www.dygym.com");
			InfoBasicaProfesor p9 = new InfoBasicaProfesor("aldo","Aldo","Vivaldi","aldo@ outlook.com",pf9,"Telón","Dada su gran estatura Aldo siempre jugó al basquetbol, hoy se dedica a enseñarlo.","","www.sportsaldo.net");
			
			
			
			manejador.CrearUsuario(p1);
			manejador.CrearUsuario(p2);
			manejador.CrearUsuario(p3);
			manejador.CrearUsuario(p4);
			manejador.CrearUsuario(p5);
			manejador.CrearUsuario(p6);
			manejador.CrearUsuario(p7);
			manejador.CrearUsuario(p8);
			manejador.CrearUsuario(p9);
		} catch (Exception e) {
			
		}
	}
	
	public void ElimiarManjeador() {
		manejador.ElimiarManjeador();
		this.manejador=null;
	}
}
