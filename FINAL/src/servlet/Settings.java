package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoriaBean;
import beans.MonedaBean;
import beans.PuestoTrabajoListarBean;
import beans.TipoTrabajoBean;
import dao.interfaces.CategoriaDao;
import dao.interfaces.MonedaDao;
import dao.interfaces.PuestoTrabajoDAO;
import dao.interfaces.TipoTrabajoDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class Settings
 */
@WebServlet("/Settings")
public class Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Settings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String key = request.getParameter("key");
		
		if(key.equals("listar")){
			PrintWriter out = response.getWriter();
			try {
				
				
				DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
				
				
				Vector<CategoriaBean> categorias = new Vector<CategoriaBean>();
				CategoriaDao categoria= dao.obtenerCategoria();
				
				categorias= categoria.listar();
				
				Vector<TipoTrabajoBean> tipos= new Vector<TipoTrabajoBean>();
				TipoTrabajoDAO tipo = dao.obtenerTiposTrabajo();
				
				tipos= tipo.listar();
				
				
				Vector<MonedaBean> monedas = new Vector<MonedaBean>();
				MonedaDao moneda = dao.obtenerMoneda();
				
				monedas = moneda.listar();
				
				request.setAttribute("monedas", monedas);
				request.setAttribute("categorias", categorias);
				request.setAttribute("tipos", tipos);
				request.getRequestDispatcher("/Admi/setting.jsp").forward(request, response);
			
			
			} catch (Exception e) {
				
				// TODO: handle exception
				request.setAttribute("mensaje", "error");
				request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
				out.print(e.getMessage());
			}
		}else if(key.equals("eliminarTipos")){
			try {
				String tip = request.getParameter("tip");
				String cat = request.getParameter("cat");
				
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				TipoTrabajoDAO tipo = dao.obtenerTiposTrabajo();
				boolean flag = tipo.eliminar(Integer.parseInt(tip),Integer.parseInt(cat));
				if(flag){
					request.setAttribute("mensaje", "Tipo Eliminado");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar");
				}
				request.getRequestDispatcher("/Admi/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		else if(key.equals("eliminarMoneda")){
			try {
				String cod = request.getParameter("codigo");
				
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				MonedaDao moneda = dao.obtenerMoneda();
				boolean flag = moneda.eliminar(Integer.parseInt(cod));
				if(flag){
					request.setAttribute("mensaje", "Moneda Eliminada");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar");
				}
				request.getRequestDispatcher("/Admi/mensaje.jsp")
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
		if (dato.equals("agregarTrabajo")) {
			
				
				String nombre = request.getParameter("Descripcion");
				String idCategoria = request.getParameter("Cat");
				TipoTrabajoBean tipo = new TipoTrabajoBean();
				tipo.setTipoTrabajo(nombre);
				tipo.setIdCategoria(Integer.parseInt(idCategoria));
				DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
				TipoTrabajoDAO puesto = dao.obtenerTiposTrabajo();
				boolean flag = puesto.agregar(tipo);
			
			if(flag){
				request.setAttribute("mensaje", "Tipo guardado");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
			
			
		}else if(dato.equals("agregarMoneda")){

			String nombre = request.getParameter("Descripcion");
			MonedaBean moneda = new MonedaBean();
			moneda.setNomMoneda(nombre);
			DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
			MonedaDao monedaDao= dao.obtenerMoneda();
			boolean flag = monedaDao.agregar(moneda);
		
			if(flag){
				request.setAttribute("mensaje", "Moneda Agregada");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
	}

}
