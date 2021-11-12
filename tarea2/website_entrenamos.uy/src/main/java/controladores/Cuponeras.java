package controladores;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.CuponeraNoExisteException;
import logica.DataCuponera;
import logica.Fabrica;

public class Cuponeras extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public Cuponeras() 
	{
		super();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();
		sesion.setAttribute("nickname-user", null);
		sesion.setAttribute("estado-sesion", "no-login");
		resp.sendRedirect("/website_entrenamos.uy/home");
	}
	
	public static Set<DataCuponera> getCuponeras(){
		Set<DataCuponera> cuponeras= new HashSet<DataCuponera>();
		try {
			Set<String> cups= Fabrica.getInstance().getIctrlCuponeras().listarCuponeras();
			for (Iterator<String> iter=cups.iterator();iter.hasNext();) {
				String cup=iter.next();
				DataCuponera res=Fabrica.getInstance().getIctrlCuponeras().mostrarCuponera(cup);
				cuponeras.add(res);
			}
		
		} catch (CuponeraNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuponeras;
	}
	
	public static Set<String> getCuponerasAD(String act){
		
		return Fabrica.getInstance().getIctrlCuponeras().getCuponerasAD(act);
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
