package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.PuestoDao;
import daofactory.DAOFactory;
import beans.PuestoBean;

/**
 * Servlet implementation class Puesto
 */
@WebServlet("/Puesto")
public class Puesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Puesto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			String nombre = request.getParameter("textfield");
			PuestoBean unpuesto = new PuestoBean();
			unpuesto.setNomPTrab(nombre);
			
			DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
			PuestoDao puesto = dao.obtenerPuesto();
		boolean flag = puesto.agregar(unpuesto);
		
		if(flag){
			request.setAttribute("mensaje", "datos guardados");
		}else{
			request.setAttribute("mensaje", "ocurrio un error");
		}
		request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
		} catch (Exception e) {
			
			// TODO: handle exception
			request.setAttribute("mensaje", "none");
			out.print(e.getMessage());
		}
	}

}
