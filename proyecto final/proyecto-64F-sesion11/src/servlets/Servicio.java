package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ServicioBean;

import dao.interfaces.ServicioDao;
import daofactory.DAOFactory;

/**
 * Servlet implementation class Servicio
 */
@WebServlet("/Servicio")
public class Servicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dato = request.getParameter("funcion");
		
		if(dato.equals("agregar")){
			
			response.sendRedirect("admin/servicio_agregar.jsp");
		}else if(dato.equals("listar")){
			try {
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				ServicioDao servicio = dao.obtenerServicio();
				Vector<ServicioBean> servicios = servicio.listar();
				
				request.setAttribute("servicios", servicios);
				
				request.getRequestDispatcher("/admin/servicio_listar.jsp")
												.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			//response.sendRedirect("admin/servicio_listar.jsp");
		}else if(dato.equals("eliminar")){
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				ServicioDao servicio = dao.obtenerServicio();
				boolean flag = servicio.eliminar(Integer.parseInt(codigo));
				if(flag){
					request.setAttribute("mensaje", "Servicio eliminado");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error");
				}
				request.getRequestDispatcher("/admin/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}else if(dato.equals("editar")){
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				ServicioDao servicio = dao.obtenerServicio();
				ServicioBean bean = 
						servicio.preactualizar(Integer.parseInt(codigo));
				
				request.setAttribute("servicio", bean);
				request.getRequestDispatcher("/admin/servicio_editar.jsp")
										.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			String dato = request.getParameter("funcion");
			if(dato.equals("agregar")){
				String nombre = request.getParameter("txt_nombre");
				ServicioBean unservicio = new ServicioBean();
				unservicio.setNombre(nombre);
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				ServicioDao servicio = dao.obtenerServicio();
				boolean flag = servicio.agregar(unservicio);
				
				if(flag){
					request.setAttribute("mensaje", "datos guardados");
				}else{
					request.setAttribute("mensaje", "ocurrio un error");
				}
				request.getRequestDispatcher("/admin/mensaje.jsp").forward(request, response);
				
			}else if(dato.equals("editar")){
				String nombre = request.getParameter("txt_nombre");
				String id = request.getParameter("txt_id");
				ServicioBean bean = new ServicioBean();
				bean.setNombre(nombre);
				bean.setId(Integer.parseInt(id));
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				ServicioDao servicio = dao.obtenerServicio();
				boolean flag =
							servicio.actualizar(bean);
				if(flag){
					request.setAttribute("mensaje", "datos actualizados");
				}else{
					request.setAttribute("mensaje", "ocurrio un error");
				}
				request.getRequestDispatcher("/admin/mensaje.jsp")
											.forward(request, response);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	}

}
