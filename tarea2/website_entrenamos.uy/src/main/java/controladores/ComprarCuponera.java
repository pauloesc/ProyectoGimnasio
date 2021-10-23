package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadDeportivaRepetidaException;
import excepciones.ClaseLlenaException;
import excepciones.ClaseYaCompradaException;
import excepciones.CuponeraCompradaException;
import logica.DataCuponera;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlUsuarios;

/**
 * Servlet implementation class RegistroAClase
 */
@WebServlet("/ComprarCuponera")
public class ComprarCuponera extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static IctrlCuponeras ctrlCuponeras = Fabrica.getInstance().getIctrlCuponeras();
    public ComprarCuponera() {
        super();
        
    }

    	
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();
    	Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		boolean bien = false;
    	
		
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = ICU.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
		
		if (bien) 
			req.setAttribute("comprahab", true);
		else 
			req.setAttribute("comprahab", false);
		
		
		req.getRequestDispatcher("/WEB-INF/cuponeras/consultaCuponera.jsp").forward(req, resp);

    	
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
