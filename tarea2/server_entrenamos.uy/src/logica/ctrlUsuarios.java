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
import excepciones.UsuarioInexistenteException;

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
			
			String institucionesDep = iterate_value.next().toString();
			vector.add(institucionesDep);
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
		Socio socio = (Socio) manejador.findUsuario(nick);
		
		return socio.mostrarNombreCuponerasDisponibles(actDept); 
	}
	
	public Set<String> mostrarNicknameSocios() {
		return manejador.mostrarNicknameSocios();
	}
	
	public void seguirUsuario(String seguidor, String seguido) {
		if ( !seguidor.equals(seguido) ) {
			Usuario sgr = manejador.findUsuario(seguidor);
			sgr.seguir(manejador.findUsuario(seguido));
		}
	}
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {
		if ( !seguidor.equals(seguido) ) {
			Usuario sgr = manejador.findUsuario(seguidor);
			sgr.dejarDeSeguir(manejador.findUsuario(seguido));
		}
	}
	
	public boolean esSocio(String nick) throws UsuarioInexistenteException {
		Usuario usuario = manejador.findUsuario(nick);
		
		if (usuario != null) {
			if (usuario.getClass() == Socio.class) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new UsuarioInexistenteException();
		}
	
	}
	
	public void cargarUsuarios() {
		//socios
		Date fecha1 = null, fecha2 = null, fecha3 = null, fecha4 = null, fecha5 = null, fecha6 = null, fecha7 = null, fecha8 = null, fecha9 = null;
		try {
			fecha1 = new SimpleDateFormat("dd/MM/yy").parse("31/12/1971");
			fecha2 = new SimpleDateFormat("dd/MM/yy").parse("15/11/1983");
			fecha3 = new SimpleDateFormat("dd/MM/yy").parse("15/04/1990");
			fecha4 = new SimpleDateFormat("dd/MM/yy").parse("15/05/1959");
			fecha5 = new SimpleDateFormat("dd/MM/yy").parse("28/01/1950");
			fecha6 = new SimpleDateFormat("dd/MM/yy").parse("17/03/1976");
			fecha7 = new SimpleDateFormat("dd/MM/yy").parse("14/02/1955");
			fecha8 = new SimpleDateFormat("dd/MM/yy").parse("23/02/1987");
			fecha9 = new SimpleDateFormat("dd/MM/yy").parse("08/05/1937");
			
			InfoBasicaSocio socio1 = new InfoBasicaSocio("Emi71", "Emiliano", "Lucas", "emi71@gmail.com", fecha1, "asdfg456", "https://bit.ly/3lxoBvZ");
			InfoBasicaSocio socio2 = new InfoBasicaSocio("caro", "Carolina", "Omega", "caro@gmail.com", fecha2, "123rtgfdv", "https://bit.ly/3AfcJER");
			InfoBasicaSocio socio3 = new InfoBasicaSocio("euge", "Eugenia", "Williams", "e.will@gmail.com", fecha3, "poiuy086", "https://bit.ly/3Afz59x");
			InfoBasicaSocio socio4 = new InfoBasicaSocio("guille", "Guillermo", "Hector", "ghector@gmail.com", fecha4, "GTO468", "https://bit.ly/2XkrKH9");
			InfoBasicaSocio socio5 = new InfoBasicaSocio("sergiop", "Sergio", "Perez", "sergi@gmail.com.uy", fecha5, "HGF135", "https://bit.ly/3ElkVG2");
			InfoBasicaSocio socio6 = new InfoBasicaSocio("andy", "Andrés", "Roman", "chino@gmail.org.uy", fecha6, "lkj65D", "https://bit.ly/3hDWgTD");
			InfoBasicaSocio socio7 = new InfoBasicaSocio("tonyp", "Antonio", "Paz", "eltony@gmail.org.uy", fecha7, "jhvf395", "https://bit.ly/3Ai4jMW");
			InfoBasicaSocio socio8 = new InfoBasicaSocio("m1k4", "Micaela", "Lopez", "mika@gmail.com.ar", fecha8, "ijngr024", "https://bit.ly/3zglsWf");
			InfoBasicaSocio socio9 = new InfoBasicaSocio("charly", "Carlos", "Boston", "charly@gmail.com.uy", fecha9, "987mnbgh", "https://bit.ly/2YRWDTQ");
			
			manejador.CrearUsuario(socio1);
			manejador.CrearUsuario(socio2);
			manejador.CrearUsuario(socio3);
			manejador.CrearUsuario(socio4);
			manejador.CrearUsuario(socio5);
			manejador.CrearUsuario(socio6);
			manejador.CrearUsuario(socio7);
			manejador.CrearUsuario(socio8);
			manejador.CrearUsuario(socio9);
	
		} catch(Exception e) {
			//nada
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
			
			InfoBasicaProfesor prof1 = new InfoBasicaProfesor("viktor", "Victor", "Perez", "vperez@fuerza.com", pf1, "lkj34df", "https://bit.ly/3zetdMl", "Fuerza Bruta", "Victor es un apasionado de los músculos. Sus clases son organizadas en función de distintos aparatos y pesas con el objetivo de desarrollar músculos", "Victor nació en Moscow en 1977. En el año 2005 emigró a Uruguay luego de quedar encantado con el país en un viaje turístico", "www.vikgym.com");
			InfoBasicaProfesor prof2 = new InfoBasicaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com", pf2, "poke579", "https://bit.ly/3lKq8Px", "Telón", "A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball", "Denis fue un jugador de voleibol profesional.", "www.depecho.com");
			InfoBasicaProfesor prof3 = new InfoBasicaProfesor("clazar", "Carlos", "Lazaro", "claz4r0@hotmail.com", pf3, "mkji648", "https://bit.ly/2VJvT6S", "Instituto Natural", "Carlos es un profesor muy divertido cuyas clases de aeróbica están cargadas de energía.", "El interés por la actividad física llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.", "www.enforma.com");
			InfoBasicaProfesor prof4 = new InfoBasicaProfesor("TheBoss", "Bruno", "Sosa", "bruceTheBoss@gmail.com", pf4, "fcku0123", "https://bit.ly/3kdT9TV", "Fuerza Bruta", "Bruno es un ex-boxeardor que busca entrenar a futuros campeones.", "Bruno, mejor conocido como Bruce en el ring, compitió como boxeador entre los años 60s y 70s.", "www.bruce.net");
			InfoBasicaProfesor prof5 = new InfoBasicaProfesor("Nelson", "Luis", "Nelson", "nelson@hotmail.com", pf5, "vbmn4r", "https://bit.ly/3lxsDo7", "Telón", "Profesor de natación. Especializado en braza y mariposa.", "", "www.nelson.uy");
			InfoBasicaProfesor prof6 = new InfoBasicaProfesor("lale", "Laura", "Leyes", "la_le@outlook.com", pf6, "ncnl123", "https://bit.ly/3EmlY8F", "Telón", "Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a enseñar tácticas de futbol", "Jugadora profesional de futbol desde 2010 a 2020.", "www.laley.com");
			InfoBasicaProfesor prof7 = new InfoBasicaProfesor("prisc", "Priscila", "Pappo", "pripa@gmail.com", pf7, "mny101", "", "Olympic", "Laura tiene un gran interés por los deportes olímpicos.", "", "www.pi314.net");
			InfoBasicaProfesor prof8 = new InfoBasicaProfesor("dagost", "Daiana", "Agostini", "d_1940_ago@gmail.com", pf8, "1o1vbm", "https://bit.ly/3hB3zvo", "Olympic", "Profesora dedicada y exigente. No acepta un “no puedo” como respuesta.", "", "www.dygym.com");
			InfoBasicaProfesor prof9 = new InfoBasicaProfesor("aldo", "Aldo", "Vivaldi", "aldo@ outlook.com", pf9, "ultraton01", "https://bit.ly/2VLnzUj", "Telón", "Dada su gran estatura Aldo siempre jugó al basquetbol, hoy se dedica a enseñarlo.", "", "www.sportsaldo.net");
			
			
			
			manejador.CrearUsuario(prof1);
			manejador.CrearUsuario(prof2);
			manejador.CrearUsuario(prof3);
			manejador.CrearUsuario(prof4);
			manejador.CrearUsuario(prof5);
			manejador.CrearUsuario(prof6);
			manejador.CrearUsuario(prof7);
			manejador.CrearUsuario(prof8);
			manejador.CrearUsuario(prof9);
			
			
			
			// seguir usuarios
			seguirUsuario("Emi71", "guille");
			seguirUsuario("caro", "euge");
			seguirUsuario("caro", "guille");
			seguirUsuario("euge", "Emi71");
			seguirUsuario("euge", "caro");
			seguirUsuario("euge", "m1k4");
			seguirUsuario("guille", "Emi71");
			seguirUsuario("guille", "caro");
			seguirUsuario("guille", "euge");
			seguirUsuario("guille", "TheBoss");
			seguirUsuario("sergiop", "euge");
			seguirUsuario("sergiop", "andy");
			seguirUsuario("sergiop", "clazar");
			seguirUsuario("andy", "caro");
			seguirUsuario("andy", "tonyp");
			seguirUsuario("andy", "clazar");
			seguirUsuario("tonyp", "caro");
			seguirUsuario("tonyp", "m1k4");
			seguirUsuario("tonyp", "charly");
			seguirUsuario("m1k4", "sergiop");
			seguirUsuario("m1k4", "tonyp");
			seguirUsuario("charly", "tonyp");
			seguirUsuario("charly", "Nelson");
			seguirUsuario("viktor", "tonyp");
			seguirUsuario("viktor", "m1k4");
			seguirUsuario("viktor", "clazar");
			seguirUsuario("viktor", "lale");
			seguirUsuario("viktor", "prisc");
			seguirUsuario("denis", "Emi71");
			seguirUsuario("denis", "caro");
			seguirUsuario("denis", "euge");
			seguirUsuario("denis", "guille");
			seguirUsuario("denis", "sergiop");
			seguirUsuario("denis", "andy");
			seguirUsuario("denis", "tonyp");
			seguirUsuario("denis", "m1k4");
			seguirUsuario("denis", "charly");
			seguirUsuario("clazar", "caro");
			seguirUsuario("clazar", "euge");
			seguirUsuario("clazar", "guille");
			seguirUsuario("clazar", "TheBoss");
			seguirUsuario("TheBoss", "guille");
			seguirUsuario("TheBoss", "andy");
			seguirUsuario("TheBoss", "m1k4");
			seguirUsuario("Nelson", "Emi71");
			seguirUsuario("Nelson", "andy");
			seguirUsuario("Nelson", "tonyp");
			seguirUsuario("Nelson", "lale");
			seguirUsuario("Nelson", "prisc");
			seguirUsuario("Nelson", "dagost");
			seguirUsuario("lale", "charly");
			seguirUsuario("lale", "Nelson");
			seguirUsuario("prisc", "charly");
			seguirUsuario("prisc", "Nelson");
			seguirUsuario("dagost", "tonyp");
			seguirUsuario("dagost", "charly");
			seguirUsuario("aldo", "andy");
			seguirUsuario("aldo", "tonyp");
			seguirUsuario("aldo", "charly");
			seguirUsuario("aldo", "lale");
			seguirUsuario("aldo", "prisc");
			seguirUsuario("aldo", "dagost");
		
		} catch (Exception e) {
			System.out.print("mal!!!");
		}
	}
	
	public void ElimiarManjeador() {
		manejador.ElimiarManjeador();
		this.manejador=null;
	}

	/* Retorna null si la autenticacion es exitosa. Si no devuelve mensaje de error.
	 * Al menos uno entre nickname y email debe valer null.
	 * Si nickname = null se autentica a traves del email, si no a traves del nickname.
	 */
	@Override
	public String autenticarUsario(String nickname, String email, String contrasena) 
	{
		if (nickname != null)
		{
			// Autenticar usando nickname
			Usuario user = manejador.findUsuario(nickname);
			if (user == null)
				return "Nickname " + nickname + " no corresponde a ningun usuario registrado.";
			if (!user.getContrasena().equals(contrasena))
				return "Contrasena incorrecta";
			else
				return null;
		}
		else
		{
			// Autenticar usando email
			Usuario user = manejador.findUsuarioPorEmail(email);
			if (user == null)
				return "El correo " + email + " no corresponde a ningun usuario registrado.";
			if (!user.getContrasena().equals(contrasena))
				return "Contrasena incorrecta";
			else
				return null;
		}
	}
	
	/*
	 * Si no existe usuario con ese email devuelve null.
	 */
	public String getNicknameUsuario(String email)
	{
		Usuario usr = manejador.findUsuarioPorEmail(email);
		if (usr == null)
			return null;
		else
			return usr.getNickname();
	}

	public Vector<String> UsuariosSiguiendo(String nickname){
		Usuario usuario = this.manejador.findUsuario(nickname);
		return usuario.SeguidosNickname();
	}
	
	
	public Vector<String> UsuariosSeguidores(String nickname){
		Usuario usuario = this.manejador.findUsuario(nickname);
		return usuario.SeguidoresNickname();
	}
	
	public Vector<DataCuponera> Cuponeras(String nickname){
		Usuario usuario = this.manejador.findUsuario(nickname);
		Socio socio = (Socio)usuario;
		return socio.Cuponeras();
	}
	
	public InfoActividadProfe InformacionActDepEstadoIngRech(String nickname){
		Usuario usuario = this.manejador.findUsuario(nickname);
		Profesor profe = (Profesor)usuario;
		return profe.InformacionActDepEstadoIngRech();
	}
}
