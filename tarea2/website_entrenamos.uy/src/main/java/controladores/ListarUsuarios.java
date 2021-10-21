package controladores;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import logica.IctrlUsuarios;
import logica.InfoBasicaUser;

/**
 * Servlet implementation class ListarUsuarios
 */
@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListarUsuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		
		Vector<String> usuariosEnSistema = ICU.UsuariosEnSistemaNickName();
		
		Vector<InfoBasicaUser> infoCompletaUsuarios = new Vector<InfoBasicaUser>(); 
		
		Iterator<String> usuarios = usuariosEnSistema.iterator();
		while( usuarios.hasNext() ) {
			String user = usuarios.next();
			infoCompletaUsuarios.add( ICU.InformacionBasicaUsuario(user) );
		}
		
		request.setAttribute("usuarios", infoCompletaUsuarios);
		request.getRequestDispatcher("/WEB-INF/usuario/listarUsuarios.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
