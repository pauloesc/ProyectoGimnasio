package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet de Logout.
 *
 * @author JP
 */
public class Logout extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  public Logout() {
    super();
  }
  
  /**
   * Setea los atributos de sesion "nickname-user" y "estado-sesion" en null y
   * "no-login" respectivamente.
   *
   * @author JP
   */
  private void processRequest(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
    HttpSession sesion = req.getSession();
    sesion.setAttribute("nickname-user", null);
    sesion.setAttribute("estado-sesion", "no-login");
    resp.sendRedirect("/website_entrenamos.uy/home");
  }

  /**
  * Implementacion del GET. Procesa el pedido llamando a "processRequest".
  *
  * @author JP
  */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
  * Implementacion del POST. Procesa el pedido llamando a "processRequest".
  *
  * @author JP
  */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    processRequest(request, response);
  }
}
