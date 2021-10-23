package controladores;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.ActividadDeportivaNoExisteException;
import logica.Cuponera;
import logica.EstadoActi;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCategorias;
import logica.IctrlCuponeras;

/**
 * Consulta de Categoria
 * 
 * @author Mauricio Barrera
 */
public class ConsultaCategoria extends HttpServlet {

	private static Fabrica fabrica = Fabrica.getInstance();
	private static IctrlADeportivas ICAD = fabrica.getIctrlADeportivas();
	private static IctrlCuponeras ICUP = fabrica.getIctrlCuponeras();
	private static IctrlCategorias ICAT = fabrica.getIctrlCategorias();
	private static final long serialVersionUID = 1L;

	public ConsultaCategoria() {
		super();
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cat = req.getParameter("categoria");
		
		if (!ConsultaCategoria.existeCategoria(cat)) {
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp").include(req, resp);
		}
		else {
		
			Set<String> actividades= new HashSet<String>();
			Set<String> resu;
			try {
				resu = ConsultaCategoria.getActividadesCat(cat);
			    for (Iterator<String> iter=resu.iterator(); iter.hasNext();) {
						String acti=iter.next();
						if (ConsultaCategoria.getEstadoActivad(acti).toString()== "ACEPTADA") {
							actividades.add(acti);
						}
			    }
			
			} catch (Exception ex) {
				actividades = null;
			}
			Set<String> cuponeras;
			
			try {
				cuponeras = ConsultaCategoria.getCuponerasCat(cat);
			} catch (Exception ex) {
				cuponeras = null;
			}
			
			req.setAttribute("actividades", actividades);
			req.setAttribute("categoria", cat);
			req.setAttribute("cuponeras", cuponeras);
			req.getRequestDispatcher("/WEB-INF/categorias/consultaCategoria.jsp").forward(req, resp);
		}
	}

	public static Set<String> getActividadesCat(String cat) {
		return ICAD.getActividadesCategoria(cat);
	}
	
	public static EstadoActi getEstadoActivad(String act) throws ActividadDeportivaNoExisteException {
		return ICAD.getDataActividad(act).getEstado();
	}
	
	
	public static Set<String> getCuponerasCat(String cat) {
		return ICUP.getCuponerasCategoria(cat);
	}
	
	public static Boolean existeCategoria(String cat) {
		Set<String> cats = ICAT.getCategorias();
		return cats.contains(cat);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
