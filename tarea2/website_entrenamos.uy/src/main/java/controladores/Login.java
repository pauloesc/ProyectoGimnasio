package controladores;

import excepciones.UsuarioInexistenteException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Fabrica;
import logica.IctrlUsuarios;
import logica.InfoBasicaUser;

/**
 * Servlet de Login.
 *
 * @author JP
 */
public class Login extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  public Login() {
    super();
  }

  /**
  * Autentica al usuario que desea iniciar sesion.
  * Si el login es exitoso, setea los attr de sesion "nickname-user",
  * "estado-sesion" y "login-error" a nickname, "logged-in" y null 
  * respectivamente. Si hubo error, asigna una descripcion del error en 
  * el atributo "login-error".
  *
  * @author JP
  */
  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession sesion = req.getSession();

    if (req.getParameter("btn_iniciarSesion") != null) {
      
      String user = req.getParameter("input_email");
      String pass = req.getParameter("input_password");
      IctrlUsuarios ctrlUsuarios = Fabrica.getInstance().getIctrlUsuarios();

      String email = null;
      String nickname = null;
      
      if (user.contains("@")) {
        email = user;
      } else {
        nickname = user;
      }

      String auth = ctrlUsuarios.autenticarUsario(nickname, email, pass);

      if (auth == null) {
        
        if (nickname == null) {
          nickname = ctrlUsuarios.getNicknameUsuario(email);
        }

        sesion.setAttribute("nickname-user", nickname);
        sesion.setAttribute("estado-sesion", "logged-in");
        sesion.setAttribute("login-error", null);
        resp.sendRedirect("/website_entrenamos.uy/home");
        
      } else {
        
        sesion.setAttribute("login-error", auth);
        req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req, resp);
        
      }
    } else {
      
      sesion.setAttribute("login-error", null);
      req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req, resp);
      
    }
  }

  /**
  * Get usuario loggeado.
  *
  * @author JP
  * @return Retorna un datatype InfoBasicaUser del usuario loggeado. Si no
  *     existe usuario loggeado lanza UsuarioInexistenteException.
  */
  public static InfoBasicaUser getUsuarioLogueado(HttpServletRequest request) 
      throws UsuarioInexistenteException {
    
    InfoBasicaUser usr = Fabrica.getInstance().getIctrlUsuarios()
        .InformacionBasicaUsuario((String) request.getSession().getAttribute("nickname-user"));

    if (usr == null) {
      throw new UsuarioInexistenteException();
    } else {
      return usr;
    }
    
  }
  
  /**
  * Implementacion del GET. Procesa el pedido llamando a "processRequest".
  *
  * @author JP
  */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    processRequest(request, response);
  }
  
  /**
  * Implementacion del POST. Procesa el pedido llamando a "processRequest".
  *
  * @author JP
  */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    processRequest(request, response);
  }
}
