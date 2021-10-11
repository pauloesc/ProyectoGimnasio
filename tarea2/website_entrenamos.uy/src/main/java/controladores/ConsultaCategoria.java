package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import logica.IctrlADeportivas;

/**
 * Consulta de Categoria
 * 
 * @author Mauricio Barrera
 */
public class ConsultaCategoria extends HttpServlet {

	private static Fabrica fabrica = Fabrica.getInstance();
	private static IctrlADeportivas ICAD = fabrica.getIctrlADeportivas();
	private static final long serialVersionUID = 1L;

	public ConsultaCategoria() {
		super();
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cat = req.getParameter("categoria");
		// verificar que categoria existe y sino llevar a errorPage
		Set<String> actividades;
		try {
			actividades = ConsultaCategoria.getActividadesCat(cat);
		} catch (Exception ex) {
			actividades = null;
		}
		req.setAttribute("actividades", actividades);
		req.setAttribute("categoria", cat);
		req.getRequestDispatcher("/WEB-INF/categorias/consultaCategoria.jsp").forward(req, resp);
	}

	public static Set<String> getActividadesCat(String cat) {
		return ICAD.getActividadesCategoria(cat);
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
