package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CategoriaBean;
import beans.TipoTrabajoBean;
import dao.interfaces.TipoTrabajoDAO;
import daofactory.MySqlDAOFactory;

public class MySql_TipoTrabajoDao extends MySqlDAOFactory implements TipoTrabajoDAO{
	
	@Override
	public boolean eliminar(int idTipo, int idCat) throws Exception{
		
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					" Trabajo where idCategoria=" + idCat+" and idTrabajo="+idTipo);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	@Override
	public boolean agregar(TipoTrabajoBean trabajo) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select max(idTrabajo)+1 from Trabajo where idCategoria="+trabajo.getIdCategoria()+";");
			int nuevo=0;
			if(rs.next()){
				nuevo=rs.getInt(1);
			}
			
			int filas = stmt.executeUpdate("insert into Trabajo(idCategoria,idTrabajo,tipoTrabajo) values ("+trabajo.getIdCategoria()
					+","+nuevo+",'"+trabajo.getTipoTrabajo()+"');");
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public boolean editar(TipoTrabajoBean categoria) throws Exception{
		return false;
		
	}
	
	@Override
	public Vector<TipoTrabajoBean> listar() throws Exception{
		Vector<TipoTrabajoBean> tipos = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idTrabajo, idCategoria, tipoTrabajo from Trabajo;");
			
			tipos = new Vector<TipoTrabajoBean>();
			TipoTrabajoBean unbean = null;
			while(rs.next()){
				unbean = new TipoTrabajoBean();
				unbean.setIdTrabajo(rs.getInt(1));
				unbean.setIdCategoria(rs.getInt(2));
				unbean.setTipoTrabajo(rs.getString(3));
				tipos.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return tipos;
	}
	
	
}