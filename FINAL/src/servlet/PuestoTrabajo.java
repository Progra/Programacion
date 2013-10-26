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
import beans.PuestoTrabajoBean;
import beans.PuestoTrabajoListarBean;
import beans.TipoTrabajoBean;
import dao.interfaces.CategoriaDao;
import dao.interfaces.MonedaDao;
import dao.interfaces.PuestoTrabajoDAO;
import dao.interfaces.TipoTrabajoDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class PuestoTrabajo
 */
@WebServlet("/PuestoTrabajo")
public class PuestoTrabajo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PuestoTrabajo() {
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
				Vector<PuestoTrabajoListarBean> puestos= new Vector<PuestoTrabajoListarBean>();
				PuestoTrabajoDAO puesto= dao.obtenerPuestoTrabajo();
				
				puestos= puesto.listar();
				
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
				request.setAttribute("puestos", puestos);
				request.getRequestDispatcher("/Admi/listado.jsp").forward(request, response);
			
			
			} catch (Exception e) {
				
				// TODO: handle exception
				request.setAttribute("mensaje", "error");
				request.getRequestDispatcher("/Admi/mensaje.jsp").forward(request, response);
				out.print(e.getMessage());
			}
		}else if(key.equals("eliminar")){
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				PuestoTrabajoDAO puesto = dao.obtenerPuestoTrabajo();
				boolean flag = puesto.eliminar(Integer.parseInt(codigo));
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
		}else if(key.equals("agregar")){
			try {
				String catego = request.getParameter("catego");
				String tipo   = request.getParameter("tipo");
				String descripcion = request.getParameter("descripcion");
				String salario = request.getParameter("salario");
				String moneda = request.getParameter("moenda");
				String inicio = request.getParameter("inicio");
				String dias = request.getParameter("dias");
				String estado = request.getParameter("estado");
				
				PuestoTrabajoBean puestoBean= new PuestoTrabajoBean();
				puestoBean.setIdCategoria(Integer.parseInt(catego));
				puestoBean.setIdTrabajo(Integer.parseInt(tipo));
				puestoBean.setDescripcion(descripcion);
				puestoBean.setSalario(Float.parseFloat(salario));
				puestoBean.setIdMoneda(Integer.parseInt(moneda));
				puestoBean.setFechaInicio(inicio);
				puestoBean.setDiasDis(Integer.parseInt(dias));
				puestoBean.setEstado(Integer.parseInt(estado));
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				PuestoTrabajoDAO puesto = dao.obtenerPuestoTrabajo();
				boolean flag = puesto.agregar(puestoBean);
				if(flag){
					request.setAttribute("mensaje", "Puesto Agregado");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al Agregar");
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
		String key = request.getParameter("key");
		String cad="";
		 if(key.equals("agregar")){
				try {
					String catego = request.getParameter("catego");
					String tipo   = request.getParameter("tipo");
					String descripcion = request.getParameter("descripcion");
					String salario = request.getParameter("salario");
					String moneda = request.getParameter("moneda");
					String inicio = request.getParameter("inicio");
					String dias = request.getParameter("dias");
					String estado = request.getParameter("estado");
					
					cad="ca "+catego
							+ "ti "+tipo
							+ "des "+descripcion
							+ "sa "+salario
							+ "mo "+moneda
							+ "ini "+inicio
							+ "di "+dias
							+ "es " +estado;
					
					PuestoTrabajoBean puestoBean= new PuestoTrabajoBean();
					
					puestoBean.setIdCategoria(Integer.parseInt(catego));
					puestoBean.setIdTrabajo(Integer.parseInt(tipo));
					puestoBean.setDescripcion(descripcion);
					puestoBean.setSalario(Float.parseFloat(salario));
					puestoBean.setIdMoneda(Integer.parseInt(moneda));
					puestoBean.setFechaInicio(inicio);
					puestoBean.setDiasDis(Integer.parseInt(dias));
					puestoBean.setEstado(Integer.parseInt(estado));
					
					DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
					PuestoTrabajoDAO puesto = dao.obtenerPuestoTrabajo();
					boolean flag = puesto.agregar(puestoBean);
					if(flag){
						request.setAttribute("mensaje", "Puesto Agregado");
					}else{
						request.setAttribute("mensaje", "Ocurrio un error al Agregar");
					}
					request.getRequestDispatcher("/Admi/mensaje.jsp")
												.forward(request, response);
				} catch (Exception e) {
					System.out.print(e.getMessage());
					request.setAttribute("mensaje", e.getMessage()+"   "+cad);
					 request.getRequestDispatcher("/Admi/mensaje.jsp")
						.forward(request, response);
				}
		 }else{
			 
			 request.setAttribute("mensaje", "No Agrego");
			 request.getRequestDispatcher("/Admi/mensaje.jsp")
				.forward(request, response);
		 }
		 
		 
		
	}

}
