package daofactory;

import dao.interfaces.MonedaDao;
import dao.interfaces.CategoriaDao;
import dao.interfaces.PuestoTrabajoDAO;
import dao.interfaces.TipoTrabajoDAO;

public abstract class DAOFactory {

	public static int MySql = 1;
	public static int SqlServer = 2;
	
	public abstract PuestoTrabajoDAO obtenerPuestoTrabajo();
	public abstract TipoTrabajoDAO obtenerTiposTrabajo();
	public abstract CategoriaDao obtenerCategoria();
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

