package controladores;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.CuponeraNoExisteException;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IctrlCuponeras;

@WebServlet("/ListaCuponeras")
public class ListaCuponeras extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static IctrlCuponeras ctrlCuponeras = Fabrica.getInstance().getIctrlCuponeras();
	
	public ListaCuponeras() 
	{
		super();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String pag = req.getParameter("n");
		Integer pagnum= Integer.parseInt(pag);
		
		Set<DataCuponera> cups=ListaCuponeras.getCuponeras();
		Integer total= cups.size();
		req.setAttribute("pag", pagnum);
		req.setAttribute("cups", cups);
		req.setAttribute("totalcups", total);
		req.getRequestDispatcher("/WEB-INF/cuponeras/listaCuponeras.jsp").forward(req, resp);
		
	}
	
	public static Set<DataCuponera> getCuponeras(){
		Set<DataCuponera> cuponeras= new HashSet<DataCuponera>();
		try {
			Set<String> cups= ctrlCuponeras.listarCuponeras();
			for (Iterator<String> iter=cups.iterator();iter.hasNext();) {
				String cup=iter.next();
				DataCuponera res=ctrlCuponeras.mostrarCuponera(cup);
				cuponeras.add(res);
			}
		
		} catch (CuponeraNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
