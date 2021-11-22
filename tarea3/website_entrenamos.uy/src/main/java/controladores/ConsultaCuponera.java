package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import publicadores.CuponeraCompradaException_Exception;
import publicadores.DataCuponera;
import publicadores.WebServicesControladorUsuario;
import publicadores.WebServicesControladorUsuarioService;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;

@WebServlet("/ConsultaCuponera")
public class ConsultaCuponera extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesControladorUsuarioService serviceUsuarios;
	private static WebServicesControladorUsuario portUsuarios;   
	
	
	
	public ConsultaCuponera() 
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
		
		Date date = new Date();
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		XMLGregorianCalendar xmlDate = null;
		
		try {
	            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		
		Boolean comprahab1=false;
		
		try {
			String comp = req.getParameter("comprahab");
			comprahab1= Boolean.parseBoolean(comp);
		}catch (Exception e) {
			comprahab1=false;
		}
		
		WebServicesCuponerasService serviceCUP = new WebServicesCuponerasService();
		WebServicesCuponeras portCUP = serviceCUP.getWebServicesCuponerasPort();
		
		if (bien && comprahab1) {
			String nomP = (String) sesion.getAttribute("nickname-user");
			try {
				portCUP.comprarCuponera(xmlDate, cup, nomP);
				req.setAttribute("msjcompra", "La cuponera se ha comprado con exito.");
				req.setAttribute("compra", true);
			} catch (CuponeraCompradaException_Exception e) {
				req.setAttribute("msjcompra", e.getMessage());
				req.setAttribute("compra", false);
			}  
		}
		
		req.getRequestDispatcher("/WEB-INF/cuponeras/consultaCuponera.jsp").forward(req, resp);
	}
	
		
	public static DataCuponera getDataCuponera(String cup){
		WebServicesCuponerasService serviceCUP = new WebServicesCuponerasService();
		WebServicesCuponeras portCUP = serviceCUP.getWebServicesCuponerasPort();
		
		DataCuponera dtCuponera;
		
		try {
			dtCuponera = portCUP.mostrarCuponera(cup);
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
