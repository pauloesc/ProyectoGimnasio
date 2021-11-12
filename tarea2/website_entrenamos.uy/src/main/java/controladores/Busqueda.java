package controladores;

import java.io.IOException;
import java.util.Set;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCategorias;
import logica.IctrlIDeportivas;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;
import publicadores.CuponeraNoExisteException_Exception;
import publicadores.DataCuponera;
import logica.DataActividad;

public class Busqueda extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  public Busqueda() {
    super();
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	
	WebServicesCuponerasService serviceCUP = new WebServicesCuponerasService();
	WebServicesCuponeras portCUP = serviceCUP.getWebServicesCuponerasPort();
	
	
	IctrlADeportivas ctrlAct = Fabrica.getInstance().getIctrlADeportivas();
	IctrlIDeportivas ctrlIns = Fabrica.getInstance().getIctrlIDeportivas();
	IctrlCategorias ctrlCat = Fabrica.getInstance().getIctrlCategorias();
	
	String consulta = req.getParameter("query").toLowerCase();
	
	List<DataCuponera> resultCup=null;

		try {
			resultCup = portCUP.buscarCuponeras(consulta).getLista();
		} catch (CuponeraNoExisteException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	Set<DataActividad> resultAct = ctrlAct.buscarActividades(consulta);
	Set<String> instituciones = ctrlIns.darNombreInstituciones();
	Set<String> categorias = ctrlCat.getCategorias();
	
	req.setAttribute("resultCup", resultCup);
	req.setAttribute("resultAct", resultAct);
	req.setAttribute("consulta", consulta);
	req.setAttribute("instituciones", instituciones);
	req.setAttribute("categorias", categorias);
	req.getRequestDispatcher("/WEB-INF/busqueda/busqueda.jsp").forward(req, resp);
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    processRequest(request, response);
    
  }

}
