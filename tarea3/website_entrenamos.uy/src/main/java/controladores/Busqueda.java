package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.CuponeraNoExisteException_Exception;

import publicadores.DataCuponera;
import publicadores.DataActividad;

import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;
import publicadores.WebServicesIDeportivas;
import publicadores.WebServicesIDeportivasService;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;
import publicadores.WebServicesCategorias;
import publicadores.WebServicesCategoriasService;

public class Busqueda extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  private static WebServicesCuponerasService serviceCuponeras;
  private static WebServicesCuponeras portCuponeras;
	
  private static WebServicesADeportivasService serviceActividades;
  private static WebServicesADeportivas portActividades;
  
  private static WebServicesCategoriasService serviceCategorias;
  private static WebServicesCategorias portCategorias;
	
  private static WebServicesIDeportivasService serviceInstituciones;
  private static WebServicesIDeportivas portInstituciones;
  
  public Busqueda() {
    super();
    
	serviceCuponeras = new WebServicesCuponerasService();
	portCuponeras = serviceCuponeras.getWebServicesCuponerasPort();
	
	serviceActividades = new WebServicesADeportivasService();
	portActividades = serviceActividades.getWebServicesADeportivasPort();
	
	serviceInstituciones = new WebServicesIDeportivasService();
	portInstituciones = serviceInstituciones
			.getWebServicesIDeportivasPort();
	
	serviceCategorias = new WebServicesCategoriasService();
	portCategorias = serviceCategorias
			.getWebServicesCategoriasPort();
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	
	String consulta = req.getParameter("query").toLowerCase();
	
	List<DataCuponera> resultCup = null;

		try {
			resultCup = portCuponeras.buscarCuponeras(consulta).getLista();
		} catch (CuponeraNoExisteException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	List<DataActividad> resultAct = portActividades.buscarActividades(consulta)
			.getItem();
	
	List<String> instituciones = portInstituciones.darNombreInstituciones()
			.getItem();
	List<String> categorias = portCategorias.getCategorias().getItem();
	
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
