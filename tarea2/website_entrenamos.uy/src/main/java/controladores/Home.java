package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCategorias;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;

/**
* Home Servlet.
*
* @author JP
*/
public class Home extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  /**
  * Constructor servlet. Carga datos si aún no fueron cargados.
  *
  * @author JP
  */
  public Home() {
    super();
    // carga de datos hardcodeados de la logica
    Fabrica fabrica = Fabrica.getInstance();
    
    IctrlIDeportivas ctrlInstDep = fabrica.getIctrlIDeportivas();
    ctrlInstDep.cargarDatosIDeportivas();
    
    IctrlCategorias ctrlCat = fabrica.getIctrlCategorias();       
    ctrlCat.cargarCategorias();
    
    IctrlADeportivas ctrlActDep = fabrica.getIctrlADeportivas();
    ctrlActDep.cargarDatosADeportivas();
    
    IctrlUsuarios ctrlUsuarios = fabrica.getIctrlUsuarios();
    ctrlUsuarios.cargarUsuarios();
    
    IctrlCuponeras ctrlCuponeras = fabrica.getIctrlCuponeras();
    ctrlCuponeras.cargarDatosCuponeras();

    IctrlClases ctrlClases = fabrica.getIctrlClases();
    ctrlClases.cargarDatosClases();
    ctrlClases.cargarRegistroAClases();

  }

  /**
  * Crea el atributo "estado_sesion" en la sesion actual.
  * Los valores posibles son:
  *   1) "no-login"
  *   2) "logged-in"
  *
  * @author JP
  */
  public static void iniciarSesion(HttpServletRequest request) {

    HttpSession session = request.getSession();
    if (session.getAttribute("estado_sesion") == null) {
      session.setAttribute("estado_sesion", "no_login");
    }
    
  }
  
  /**
  * Retorna el estado actual de la sesion (atributo "estado-sesion").
  * Los valores posibles son:
  *   1) "no-login"
  *   2) "logged-in"
  *
  * @author JP
  * @return String que representa el estado de la sesion
  */
  public static String getEstadoSesion(HttpServletRequest request) {

    return (String) request.getSession().getAttribute("estado_sesion");
    
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    iniciarSesion(req);

    req.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(req, resp);

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
