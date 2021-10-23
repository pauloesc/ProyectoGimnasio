package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.DataCuponera;

public class Busqueda extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  public Busqueda() {
    super();
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	
	IctrlCuponeras ctrlCup = Fabrica.getInstance().getIctrlCuponeras();
	
	String consulta = req.getParameter("query").toLowerCase();
	
	Set<DataCuponera> resultCup = ctrlCup.buscarCuponeras(consulta);
	
	req.setAttribute("resultCup", resultCup);
	req.setAttribute("consulta", consulta);
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
