package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ActividadDeportivaNoExisteException_Exception;
import publicadores.CuponeraNoExisteException_Exception;
import publicadores.DataActividadArray;
import publicadores.DataCuponera;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;
import publicadores.WebServicesIDeportivas;
import publicadores.WebServicesIDeportivasService;

/**
* Home Servlet.
*
* @author JP
*/
public class Home extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  private static WebServicesADeportivasService serviceActividades;
  private static WebServicesADeportivas portActividades;
  
  private static WebServicesIDeportivasService serviceInstituciones;
  private static WebServicesIDeportivas portInstituciones;
	

  /**
  * Constructor servlet. Carga datos si aún no fueron cargados.
  *
  * @author JP
  */
  public Home() {
    super();
	serviceActividades = new WebServicesADeportivasService();
	portActividades = serviceActividades.getWebServicesADeportivasPort();
	
	serviceInstituciones = new WebServicesIDeportivasService();
	portInstituciones = serviceInstituciones.getWebServicesIDeportivasPort();
	
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
    
    HttpSession session = req.getSession();
    Set<String> inst = new HashSet<String>(portInstituciones.darNombreInstituciones().getItem());
    session.setAttribute("Instituciones", inst);
	Set<String> cats= Categorias.getCategorias();
	session.setAttribute("Categorias", cats);
    
    Set<publicadores.DataActividad> acts = new HashSet<publicadores.DataActividad>();
	try {
		DataActividadArray actsarr = portActividades.getDataActividadesIngresadas();
		acts.addAll(actsarr.getItem());
	} catch (ActividadDeportivaNoExisteException_Exception e) {
		acts = null;
	}
	WebServicesCuponerasService serviceCUP = new WebServicesCuponerasService();
	WebServicesCuponeras portCUP = serviceCUP.getWebServicesCuponerasPort();
	
	List<DataCuponera> cuponeras= new ArrayList<DataCuponera>();

		try {
			List<String> cups = portCUP.listarCuponeras().getSet();
			for (Iterator<String> iter=cups.iterator();iter.hasNext();) {
				String cup=iter.next();
				DataCuponera res = portCUP.mostrarCuponera(cup);
				cuponeras.add(res);
		} 
			} catch (CuponeraNoExisteException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	req.setAttribute("cuponeras", cuponeras);	
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
