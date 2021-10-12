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
	
	public void seguirUsuario(String seguidor, String seguido) {
		Usuario sgr = manejador.findUsuario(seguidor);
		sgr.seguir(manejador.findUsuario(seguido));
	}
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {
		Usuario sgr = manejador.findUsuario(seguidor);
		sgr.dejarDeSeguir(manejador.findUsuario(seguido));
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
			
			InfoBasicaSocio u1 = new InfoBasicaSocio("Emi71","Emiliano","Lucas","emi71@gmail.com",f1,"asdfg456","https://bit.ly/3lxoBvZ");
			InfoBasicaSocio u2 = new InfoBasicaSocio("caro","Carolina","Omega","caro@gmail.com",f2,"123rtgfdv","https://bit.ly/3AfcJER");
			InfoBasicaSocio u3 = new InfoBasicaSocio("euge","Eugenia","Williams","e.will@gmail.com",f3,"poiuy086","https://bit.ly/3Afz59x");
			InfoBasicaSocio u4 = new InfoBasicaSocio("guille","Guillermo","Hector","ghector@gmail.com",f4,"GTO468","https://bit.ly/2XkrKH9");
			InfoBasicaSocio u5 = new InfoBasicaSocio("sergiop","Sergio","Perez","sergi@gmail.com.uy",f5,"HGF135","https://bit.ly/3ElkVG2");
			InfoBasicaSocio u6 = new InfoBasicaSocio("andy","Andrés","Roman","chino@gmail.org.uy",f6,"lkj65D","https://bit.ly/3hDWgTD");
			InfoBasicaSocio u7 = new InfoBasicaSocio("tonyp","Antonio","Paz","eltony@gmail.org.uy",f7,"jhvf395","https://bit.ly/3Ai4jMW");
			InfoBasicaSocio u8 = new InfoBasicaSocio("m1k4","Micaela","Lopez","mika@gmail.com.ar",f8,"ijngr024","https://bit.ly/3zglsWf");
			InfoBasicaSocio u9 = new InfoBasicaSocio("charly","Carlos","Boston","charly@gmail.com.uy",f9,"987mnbgh","https://bit.ly/2YRWDTQ");
			
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
			
			InfoBasicaProfesor p1 = new InfoBasicaProfesor("viktor","Victor","Perez","vperez@fuerza.com",pf1,"lkj34df","https://bit.ly/3zetdMl","Fuerza Bruta","Victor es un apasionado de los músculos. Sus clases son organizadas en función de distintos aparatos y pesas con el objetivo de desarrollar músculos","Victor nació en Moscow en 1977. En el año 2005 emigró a Uruguay luego de quedar encantado con el país en un viaje turístico","www.vikgym.com");
			InfoBasicaProfesor p2 = new InfoBasicaProfesor("denis","Denis","Miguel","den80@fuerza.com",pf2,"poke579","https://bit.ly/3lKq8Px","Telon","A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball","Denis fue un jugador de voleibol profesional.","www.depecho.com");
			InfoBasicaProfesor p3 = new InfoBasicaProfesor("clazar","Carlos","Lazaro","claz4r0@hotmail.com",pf3,"mkji648","https://bit.ly/2VJvT6S","Instituto Natural","Carlos es un profesor muy divertido cuyas clases de aeróbica están cargadas de energía.","El interés por la actividad física llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.","www.enforma.com");
			InfoBasicaProfesor p4 = new InfoBasicaProfesor("TheBoss","Bruno","Sosa","bruceTheBoss@gmail.com",pf4,"fcku0123","https://bit.ly/3kdT9TV","Fuerza Bruta","Bruno es un ex-boxeardor que busca entrenar a futuros campeones.","Bruno, mejor conocido como Bruce en el ring, compitió como boxeador entre los años 60s y 70s.","www.bruce.net");
			InfoBasicaProfesor p5 = new InfoBasicaProfesor("Nelson","Luis","Nelson","nelson@hotmail.com",pf5,"vbmn4r","https://bit.ly/3lxsDo7","Telon","Profesor de natación. Especializado en braza y mariposa.","","www.nelson.uy");
			InfoBasicaProfesor p6 = new InfoBasicaProfesor("lale","Laura","Leyes","la_le@outlook.com",pf6,"ncnl123","https://bit.ly/3EmlY8F","Telon","Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a enseñar tácticas de futbol","Jugadora profesional de futbol desde 2010 a 2020.","www.laley.com");
			InfoBasicaProfesor p7 = new InfoBasicaProfesor("prisc","Priscila","Pappo","pripa@gmail.com",pf7,"mny101","","Olympic","Laura tiene un gran interés por los deportes olímpicos.","","www.pi314.net");
			InfoBasicaProfesor p8 = new InfoBasicaProfesor("dagost","Daiana","Agostini","d_1940_ago@gmail.com",pf8,"1o1vbm","https://bit.ly/3hB3zvo","Olympic","Profesora dedicada y exigente. No acepta un “no puedo” como respuesta.","","www.dygym.com");
			InfoBasicaProfesor p9 = new InfoBasicaProfesor("aldo","Aldo","Vivaldi","aldo@ outlook.com",pf9,"ultraton01","https://bit.ly/2VLnzUj","Telon","Dada su gran estatura Aldo siempre jugó al basquetbol, hoy se dedica a enseñarlo.","","www.sportsaldo.net");
			
			
			
			manejador.CrearUsuario(p1);
			manejador.CrearUsuario(p2);
			manejador.CrearUsuario(p3);
			manejador.CrearUsuario(p4);
			manejador.CrearUsuario(p5);
			manejador.CrearUsuario(p6);
			manejador.CrearUsuario(p7);
			manejador.CrearUsuario(p8);
			manejador.CrearUsuario(p9);
			
			
			
			// seguir usuarios
			seguirUsuario("Emi71","guille");
			seguirUsuario("caro","euge");
			seguirUsuario("caro","guille");
			seguirUsuario("euge","Emi71");
			seguirUsuario("euge","caro");
			seguirUsuario("euge","m1k4");
			seguirUsuario("guille","Emi71");
			seguirUsuario("guille","caro");
			seguirUsuario("guille","euge");
			seguirUsuario("guille","TheBoss");
			seguirUsuario("sergiop","euge");
			seguirUsuario("sergiop","andy");
			seguirUsuario("sergiop","clazar");
			seguirUsuario("andy","caro");
			seguirUsuario("andy","tonyp");
			seguirUsuario("andy","clazar");
			seguirUsuario("tonyp","caro");
			seguirUsuario("tonyp","m1k4");
			seguirUsuario("tonyp","charly");
			seguirUsuario("m1k4","sergiop");
			seguirUsuario("m1k4","tonyp");
			seguirUsuario("charly","tonyp");
			seguirUsuario("charly","Nelson");
			seguirUsuario("viktor","tonyp");
			seguirUsuario("viktor","m1k4");
			seguirUsuario("viktor","clazar");
			seguirUsuario("viktor","lale");
			seguirUsuario("viktor","prisc");
			seguirUsuario("denis","Emi71");
			seguirUsuario("denis","caro");
			seguirUsuario("denis","euge");
			seguirUsuario("denis","guille");
			seguirUsuario("denis","sergiop");
			seguirUsuario("denis","andy");
			seguirUsuario("denis","tonyp");
			seguirUsuario("denis","m1k4");
			seguirUsuario("denis","charly");
			seguirUsuario("clazar","caro");
			seguirUsuario("clazar","euge");
			seguirUsuario("clazar","guille");
			seguirUsuario("clazar","TheBoss");
			seguirUsuario("TheBoss","guille");
			seguirUsuario("TheBoss","andy");
			seguirUsuario("TheBoss","m1k4");
			seguirUsuario("Nelson","Emi71");
			seguirUsuario("Nelson","andy");
			seguirUsuario("Nelson","tonyp");
			seguirUsuario("Nelson","lale");
			seguirUsuario("Nelson","prisc");
			seguirUsuario("Nelson","dagost");
			seguirUsuario("lale","charly");
			seguirUsuario("lale","Nelson");
			seguirUsuario("prisc","charly");
			seguirUsuario("prisc","Nelson");
			seguirUsuario("dagost","tonyp");
			seguirUsuario("dagost","charly");
			seguirUsuario("aldo","andy");
			seguirUsuario("aldo","tonyp");
			seguirUsuario("aldo","charly");
			seguirUsuario("aldo","lale");
			seguirUsuario("aldo","prisc");
			seguirUsuario("aldo","dagost");
		
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
		Usuario u = this.manejador.findUsuario(nickname);
		return u.SeguidosNickname();
	}
	
	
	public Vector<String> UsuariosSeguidores(String nickname){
		Usuario u = this.manejador.findUsuario(nickname);
		return u.SeguidoresNickname();
	}
	
	public Vector<DataCuponera> Cuponeras(String nickname){
		Usuario u = this.manejador.findUsuario(nickname);
		Socio s = (Socio)u;
		return s.Cuponeras();
	}
	
	public InfoActividadProfe InformacionActDepEstadoIngRech(String nickname){
		Usuario u = this.manejador.findUsuario(nickname);
		Profesor p = (Profesor)u;
		return p.InformacionActDepEstadoIngRech();
	}
}
