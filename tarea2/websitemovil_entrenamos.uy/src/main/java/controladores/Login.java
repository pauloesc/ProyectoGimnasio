package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.WebServicesControladorUsuarioService;

public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;
	
  public Login() {
    super();
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  
  
				

	/**			
				
				if (chk==null) chk="off";
				
				if ( chk.equals("on") ) {

					
					
		*/
	  

	}
	
	public static publicadores.InfoBasicaUser getUsuarioLogueado(HttpServletRequest request)
		throws publicadores.UsuarioDisponibilidadException_Exception
	{		
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------
		
		
		publicadores.InfoBasicaUser usr = null;
		usr = port.informacionBasicaUsuario( (String) request.getSession().getAttribute("nickname-user") );
		
		if (usr == null)
			throw new publicadores.UsuarioDisponibilidadException_Exception(null, null);
		else
			return usr;
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		HttpSession sesion = req.getSession();
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------
		
		String user = req.getParameter("input_email");
		String pass = req.getParameter("input_password");
	
		String email = "", nickname = "";
		if (user.contains("@"))
			email = user;
		else
			nickname = user;
		
		publicadores.WrapperStringNull auxAuth = null;
		auxAuth = port.autenticarUsarioMovil(nickname, email, pass);
		String auth = auxAuth.getInformacion();
		
		
		//si hay usuario
		if( auth == null ) {
			
			//si ingreso con el correo
			if (nickname == null || nickname.equals("") ) {
				nickname = port.getNicknameUsuario(email);
			}
			
			sesion.setAttribute("nickname-user", nickname);
			sesion.setAttribute("estado-sesion", "logged-in");
			sesion.setAttribute("login-error", null);
			
			String recordar = req.getParameter("rec");
			
			System.out.println(recordar);
			
			if( recordar != null && recordar.equals("on") ) {
				System.out.println("sin errores");
				
		        //Creating two cookies
		        Cookie c1=new Cookie("userName", nickname);
		        Cookie c2=new Cookie("userPassword",pass);
		        c1.setMaxAge(3600);
		        c2.setMaxAge(3600);
				resp.addCookie(c1);
				resp.addCookie(c2);
				
				
			}
			
			System.out.println("como socio");
			resp.sendRedirect("/websitemovil_entrenamos.uy/home");
		}
		
		//si no hay usuario
		else {
			sesion.setAttribute("login-error", auth);
			
			
			String valoNickOEmail = "";
			String valorPass = "";
			req.setAttribute("valoNickOEmail",valoNickOEmail);
			req.setAttribute("valorPass",valorPass);
			req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req, resp);
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		
		String valoNickOEmail = "";
		String valorPass = "";

		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			
			for (Cookie cookie : cookies) {
				
				   if (cookie.getName().equals("userName")) {
					   valoNickOEmail = cookie.getValue();
				   }
				   
				   if (cookie.getName().equals("userPassword")) {
					   valorPass = cookie.getValue();
				   }
			}
			
		}
		
		req.setAttribute("valoNickOEmail",valoNickOEmail);
		req.setAttribute("valorPass",valorPass);
		req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req, resp);
	}
}
