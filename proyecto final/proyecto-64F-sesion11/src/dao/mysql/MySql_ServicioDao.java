package dao.mysql;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Vector;

import beans.ServicioBean;
import dao.interfaces.ServicioDao;
import daofactory.MySqlDAOFactory;

public class MySql_ServicioDao 
				extends MySqlDAOFactory
				implements ServicioDao {

	@Override
	public boolean eliminar(int id) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					"servicios where id=" + id);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean agregar(ServicioBean servicio) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into " +
						" servicios (nombre) " +
						" values ('" + servicio.getNombre() +"')");
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Vector<ServicioBean> listar() throws Exception {
		Vector<ServicioBean> servicios = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select id, nombre from servicios");
			
			servicios = new Vector<ServicioBean>();
			ServicioBean unbean = null;
			while(rs.next()){
				unbean = new ServicioBean();
				unbean.setId(rs.getInt("id"));
				unbean.setNombre(rs.getString("nombre"));
				servicios.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return servicios;
	}

	@Override
	public ServicioBean preactualizar(int id) throws Exception {
		ServicioBean servicio = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select id, nombre " +
					"from servicios where id=" + id);
			if(rs.next()){
				servicio = new ServicioBean();
				servicio.setId( rs.getInt("id") );
				servicio.setNombre( rs.getString("nombre") );
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return servicio;
	}

	@Override
	public boolean actualizar(ServicioBean servicio) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("update servicios " +
					"set nombre='"+servicio.getNombre()+"' " +
					"where id="+ servicio.getId());
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	
	
}
