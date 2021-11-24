package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.CuponeraNoExisteException_Exception;
import publicadores.DataCuponera;
import publicadores.WebServicesControladorUsuario;
import publicadores.WebServicesControladorUsuarioService;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;

@WebServlet("/ListaCuponeras")
public class ListaCuponeras extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesControladorUsuarioService serviceUsuarios;
	private static WebServicesControladorUsuario portUsuarios;   
		
	public ListaCuponeras() 
	{
		super();
		serviceUsuarios = new WebServicesControladorUsuarioService();
		portUsuarios = serviceUsuarios.getWebServicesControladorUsuarioPort();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();

		boolean bien = false;
    	
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = portUsuarios.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
		
		String pag = req.getParameter("n");
		Integer pagnum= Integer.parseInt(pag);
		
	
		List<DataCuponera> cups=ListaCuponeras.getCuponeras();
		Integer total= cups.size();
		
		req.setAttribute("pag", pagnum);
		req.setAttribute("cups", cups);
		req.setAttribute("totalcups", total);
		req.setAttribute("socio", bien);
		req.getRequestDispatcher("/WEB-INF/cuponeras/listaCuponeras.jsp").forward(req, resp);
		
	}
	
	public static List<DataCuponera> getCuponeras(){
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
			
			
		Collections.sort(cuponeras, new Comparator<DataCuponera>(){
		    @Override
		    public int compare(DataCuponera o1, DataCuponera o2) {
		        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
		    }
		});
		
		return cuponeras;
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
