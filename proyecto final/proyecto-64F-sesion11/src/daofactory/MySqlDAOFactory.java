package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.ServicioDao;
import dao.mysql.MySql_ServicioDao;

public class MySqlDAOFactory extends DAOFactory {
	public static Connection crearConexion(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/64f-proyecto";
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return con;
	}

	public ServicioDao obtenerServicio() {
		return new MySql_ServicioDao();
	}
}
