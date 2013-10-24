package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.MonedaDao;
import dao.interfaces.PuestoDao;
import dao.mysql.MySql_MonedaDao;
import dao.mysql.MySql_PuestoDao;

public class MySqlDAOFactory extends DAOFactory {
	public static Connection crearConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/programacion";
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}

		return con;
	}

	@Override
	public PuestoDao obtenerPuesto() {
		return new MySql_PuestoDao();
	}
	@Override
	public MonedaDao obtenerMoneda() {
		return new MySql_MonedaDao();
	}

}
