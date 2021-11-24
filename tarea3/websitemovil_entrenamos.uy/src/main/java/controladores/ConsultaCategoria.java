package controladores;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ActividadDeportivaNoExisteException_Exception;
import publicadores.DataActividad;
import publicadores.EstadoActi;

import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;
import publicadores.WebServicesCategorias;
import publicadores.WebServicesCategoriasService;

/**
 * Consulta de Categoria
 * 
 * @author Mauricio Barrera
 */
public class ConsultaCategoria extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesCategoriasService serviceCategorias;
	private static WebServicesCategorias portCategorias;
	
	private static WebServicesCuponerasService serviceCuponeras;
	private static WebServicesCuponeras portCuponeras;
	
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;

	public ConsultaCategoria() 
	{
		super();
		
		serviceCategorias = new WebServicesCategoriasService();
		portCategorias = serviceCategorias
				.getWebServicesCategoriasPort();
		
		serviceCuponeras = new WebServicesCuponerasService();
		portCuponeras = serviceCuponeras.getWebServicesCuponerasPort();
		
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
		
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String cat = req.getParameter("categoria");
		
		if (!existeCategoria(cat)) 
		{
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp")
				.include(req, resp);
		}
		else 
		{
			Set<String> actividadesAceptadas = new HashSet<String>();
			try 
			{
				Set<String> actividadesCat = ConsultaCategoria
						.getActividadesCat(cat);
				
				for (String nomActividad : actividadesCat)
				{
					if ( getEstadoActividad(nomActividad)
							.equals(EstadoActi.ACEPTADA) )	
						actividadesAceptadas.add(nomActividad);
				}
			
			} 
			catch (Exception ex) 
			{
				actividadesAceptadas = null;
			}
			
			List<String> cuponeras;
			try 
			{
				cuponeras = ConsultaCategoria.getCuponerasCat(cat);
			} 
			catch (Exception ex) 
			{
				cuponeras = null;
			}
			
			
			
			//paulo
			
			//paulo
			List<DataActividad> acts = portActividades.buscarActividades("").getItem();
			//paulo
			
			//listadeActividadesAdebolver
			List<DataActividad> actRetornar = new Vector<DataActividad>();
			
			
			for( DataActividad varActi : acts ) {
				
				if( actividadesAceptadas.contains(varActi.getNombre())  ) {
					actRetornar.add(varActi);
				}
				
			}
			
			
			req.setAttribute("actividadesConInfo", actRetornar);
			//paulo
			
			
			req.setAttribute("actividades", actividadesAceptadas);
			req.setAttribute("categoria", cat);
			req.setAttribute("cuponeras", cuponeras);
			req.getRequestDispatcher("/WEB-INF/categorias/consultaCategoria.jsp")
				.forward(req, resp);
		}
	}

	public static Set<String> getActividadesCat(String cat) 
	{	
		return new HashSet<String>(
				portActividades.getActividadesCategoria(cat).getItem() 
				);
	}
	
	public static EstadoActi getEstadoActividad(String act) 
			throws ActividadDeportivaNoExisteException_Exception 
	{
		try 
		{
			return portActividades.getDataActividad(act).getEstado();
		}
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	public static List<String> getCuponerasCat(String cat) 
	{
		return portCuponeras.getCuponerasCategoria(cat).getSet();
	}
	
	public static Boolean existeCategoria(String cat) 
	{
		List<String> cats = portCategorias.getCategorias().getItem();
		
		return cats.contains(cat);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		String nickEnSesion = (String) request.getSession().getAttribute("nickname-user");

		//si hay una sesion
		if( nickEnSesion != null ) {
			processRequest(request, response);
		}
		
		else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		processRequest(request, response);
	}
}
