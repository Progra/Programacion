package daofactory;

import dao.interfaces.MonedaDao;
import dao.interfaces.PuestoDao;

public abstract class DAOFactory {

	public static int MySql = 1;
	public static int SqlServer = 2;
	
	public abstract PuestoDao obtenerPuesto();
	public abstract MonedaDao obtenerMoneda();
	
	
	public static DAOFactory obtenerFactory(int origen){
		switch (origen) {
			case 1:
				//retornar el DAOFactory Mysql
				//return new MySqlDAOFactory();
				return new MySqlDAOFactory();
			case 2:
				//retornar el DAOFactory SqlServer
			default:
				return null;
		}

	
	}
	
	
	
	
	

}

