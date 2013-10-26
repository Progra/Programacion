package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MonedaBean;

import dao.interfaces.MonedaDao;

import daofactory.DAOFactory;

/**
 * Servlet implementation class Moneda
 */
@WebServlet("/Moneda")
public class Moneda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Moneda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		try {
			
			
			DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
			Vector<MonedaBean> monedas = new Vector<MonedaBean>();
			MonedaDao moneda = dao.obtenerMoneda();
			
			monedas = moneda.listar();
			
			request.setAttribute("monedas", monedas);
			request.getRequestDispatcher("/Admi/monedas.jsp").forward(request, response);
		
		
		} catch (Exception e) {
			
			// TODO: handle exception
			request.setAttribute("mensaje", "error");
			request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
			out.print(e.getMessage());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
