package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataCuponera;
import logica.Fabrica;
import logica.IctrlCuponeras;

@WebServlet("/ConsultaCuponera")
public class ConsultaCuponera extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static IctrlCuponeras ctrlCuponeras = Fabrica.getInstance().getIctrlCuponeras();
	
	
	public ConsultaCuponera() 
	{
		super();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String cup = req.getParameter("cuponera");
		//verificar que cuponera existe y sino llevar a errorPage
		DataCuponera cuponera = null;
		try {
			cuponera = ConsultaCuponera.getDataCuponera(cup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("cuponera", cuponera);
		req.getRequestDispatcher("/WEB-INF/cuponeras/consultaCuponera.jsp").forward(req, resp);
	}
	
		
	public static DataCuponera getDataCuponera(String cup){
		DataCuponera dtCuponera;
		try {
			dtCuponera = ctrlCuponeras.mostrarCuponera(cup);
		} 
		catch(Exception ex) {
			dtCuponera = null;
		}
		return dtCuponera;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		processRequest(request, response);
	}
}
