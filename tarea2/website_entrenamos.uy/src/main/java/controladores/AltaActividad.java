package controladores;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.ActividadDeportivaRepetidaException;
import logica.Fabrica;
import logica.IctrlADeportivas;

public class AltaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IctrlADeportivas ctrlADeportivas = Fabrica.getInstance().getIctrlADeportivas();

	public AltaActividad() {
		super();

	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ninst = req.getParameter("institucionDeportiva");
		String nprof = (String) req.getSession().getAttribute("nickname-user");
		String nact = req.getParameter("nombreActividad");
		String descrip = req.getParameter("descripcionActividad");
		String dur = req.getParameter("duracionActividad");
		String cost = req.getParameter("costoActividad");
		Date date = new Date();
		Set<String> cats = new HashSet<>(Arrays.asList(req.getParameterValues("categoriasActividad")));
		try {
			ctrlADeportivas.altaActividadDeportiva(ninst, nprof, nact, descrip, Float.parseFloat(dur),
					Float.parseFloat(cost), date, cats);
			req.setAttribute("msjAlta", "La Actividad Deportiva se ha registrado con éxito.");
			req.setAttribute("estadoAlta", true);
		} catch (ActividadDeportivaRepetidaException e) {
			req.setAttribute("msjAlta", e.getMessage());
			req.setAttribute("estadoAlta", false);
		}
		req.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(req, resp);
	}

	public static Set<String> getActividadesInst(String inst) {
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
		return acts;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("estadoAlta", null);
		request.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
