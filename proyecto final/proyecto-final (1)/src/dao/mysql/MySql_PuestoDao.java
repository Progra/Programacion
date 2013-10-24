package dao.mysql;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import beans.PuestoBean;
import dao.interfaces.PuestoDao;
import daofactory.MySqlDAOFactory;

public class MySql_PuestoDao extends MySqlDAOFactory implements PuestoDao {

	@Override
	public boolean eliminar(int idPTrab) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregar(PuestoBean puesto) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into PuestoTrabajo ( nomPTrab) values ('"+puesto.getNomPTrab()+"');");
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean editar(PuestoBean puesto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<PuestoBean> aaa() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
