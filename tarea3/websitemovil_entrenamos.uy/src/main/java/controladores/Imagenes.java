package controladores;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.IOException_Exception;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;

/**
 * Servlet implementation class Imagenes
 */
@WebServlet("/Imagenes")
public class Imagenes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imagenes() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String id = (String) request.getParameter("id");
        
        byte[] img = null;
        
        WebServicesCuponerasService serviceCUP = new WebServicesCuponerasService();
		WebServicesCuponeras portCUP = serviceCUP.getWebServicesCuponerasPort();

        try {
        	if (!(id.equals("") || id==null )) {
            img = portCUP.getFile(id);
            response.setContentType("image/jpg");
            response.setContentLength((int) img.length);
            OutputStream out = response.getOutputStream();
            //ImageIO.write(img, "png", out);
            out.write(img);
            out.close();
        	} else {
        		img = portCUP.getFile("sinimagen.jpg");
        		response.setContentType("image/jpg");
                response.setContentLength((int) img.length);
                OutputStream out = response.getOutputStream();
                //ImageIO.write(img, "png", out);
                out.write(img);
                out.close();
        	}
        } catch (Exception ex) {            
        	
        	
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

