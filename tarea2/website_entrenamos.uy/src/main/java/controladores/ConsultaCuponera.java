package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IctrlCuponeras;
import logica.IctrlUsuarios;

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
		HttpSession sesion = req.getSession();
    	Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
<<<<<<< HEAD

=======
>>>>>>> refs/heads/master
		boolean bien = false;
    	
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = ICU.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
		
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
		req.setAttribute("socio", bien);
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
