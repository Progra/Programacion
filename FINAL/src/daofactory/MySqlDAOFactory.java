package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import beans.TipoTrabajoBean;
import dao.interfaces.MonedaDao;
import dao.interfaces.CategoriaDao;
import dao.interfaces.PuestoTrabajoDAO;
import dao.interfaces.TipoTrabajoDAO;
import dao.mysql.MySql_MonedaDao;
import dao.mysql.MySql_CategoriaDao;
import dao.mysql.MySql_PuestoTrabajoDao;
import dao.mysql.MySql_TipoTrabajoDao;

public class MySqlDAOFactory extends DAOFactory {
	public static Connection crearConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/prograDB";
			con = DriverManager.getConnection(url, "root", "fiorella7");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}

		return con;
	}

	@Override
	public CategoriaDao obtenerCategoria() {
		return new MySql_CategoriaDao();
	}
	@Override
	public MonedaDao obtenerMoneda() {
		return new MySql_MonedaDao();
	}
	
	@Override
	public PuestoTrabajoDAO obtenerPuestoTrabajo() {
		return new MySql_PuestoTrabajoDao();
	}
	
	@Override
	public TipoTrabajoDAO obtenerTiposTrabajo() {
		return new MySql_TipoTrabajoDao();
	}

}
