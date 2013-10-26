package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.CategoriaDao;
import daofactory.DAOFactory;
import beans.CategoriaBean;



/**
 * Servlet implementation class Categoria
 */
@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String dato= request.getParameter("funcion");
		
		if (dato.equals("listar")) {
			try {
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				CategoriaDao categoria = dao.obtenerCategoria();
				Vector<CategoriaBean> categorias = categoria.listar();
				
				request.setAttribute("categorias", categorias);
				
				request.getRequestDispatcher("/Admi/listarCategoria.jsp")
												.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}else if (dato.equals("agregar")) {
			response.sendRedirect("Admi/addCategoria.jsp");
			
		}else if (dato.equals("eliminar")){
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				CategoriaDao categoria = dao.obtenerCategoria();
				boolean flag = categoria.eliminar(Integer.parseInt(codigo));
				if(flag){
					request.setAttribute("mensaje", "Categoria eliminada");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar");
				}
				request.getRequestDispatcher("/Admi/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}else if (dato.equals("editar")) {
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				CategoriaDao categoria = dao.obtenerCategoria();
				CategoriaBean bean = 
						categoria.preactualizar(Integer.parseInt(codigo));
				
				request.setAttribute("categoria", bean);
				request.getRequestDispatcher("/Admi/updateCategoria.jsp")
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
			
			String dato= request.getParameter("funcion");
			try {
			if (dato.equals("agregar")) {
				
					
					String nombre = request.getParameter("Descripcion");
					CategoriaBean uncategoria = new CategoriaBean();
					uncategoria.setNomCat(nombre);
					DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
					CategoriaDao puesto = dao.obtenerCategoria();
					boolean flag = puesto.agregar(uncategoria);
				
				if(flag){
					request.setAttribute("mensaje", "datos guardados");
				}else{
					request.setAttribute("mensaje", "ocurrio un error");
				}
				request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
				
				
			}else if(dato.equals("editar")){

				String nombre = request.getParameter("textfield");
				String id = request.getParameter("txt_id");
				CategoriaBean bean = new CategoriaBean();
				bean.setNomCat(nombre);
				bean.setIdCat(Integer.parseInt(id));
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				CategoriaDao categoria = dao.obtenerCategoria();
				boolean flag =categoria.editar(bean);
				if(flag){
					request.setAttribute("mensaje", "datos actualizados");
				}else{
					request.setAttribute("mensaje", "ocurrio un error");
				}
				request.getRequestDispatcher("/Admi/mensaje.jsp")
											.forward(request, response);
			}
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
	}

}
