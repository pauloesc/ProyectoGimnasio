package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadDeportivaNoExisteException;
import logica.DataActividad;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCategorias;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;

import java.util.Set;

/**
* Home Servlet.
*
* @author JP
*/
public class Home extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  private Fabrica fabrica = Fabrica.getInstance();
  private IctrlADeportivas ctrlActDep = fabrica.getIctrlADeportivas();
  
  /**
  * Constructor servlet. Carga datos si aún no fueron cargados.
  *
  * @author JP
  */
  public Home() {
    super();
    // carga de datos hardcodeados de la logica
    
    
    IctrlIDeportivas ctrlInstDep = fabrica.getIctrlIDeportivas();
    ctrlInstDep.cargarDatosIDeportivas();
    
    IctrlCategorias ctrlCat = fabrica.getIctrlCategorias();       
    ctrlCat.cargarCategorias();
    
    IctrlUsuarios ctrlUsuarios = fabrica.getIctrlUsuarios();
    ctrlUsuarios.cargarUsuarios();
    
    ctrlActDep.cargarDatosADeportivas();
    
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
    Set<DataActividad> acts;
	try {
		acts = ctrlActDep.getDataActividadesIngresadas();
	} catch (ActividadDeportivaNoExisteException e) {
		acts = null;
	}
    req.setAttribute("actividades", acts);
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
