package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CategoriaBean;
import dao.interfaces.CategoriaDao;
import daofactory.MySqlDAOFactory;

public class MySql_CategoriaDao extends MySqlDAOFactory implements CategoriaDao {

	@Override
	public boolean eliminar(int idCat) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					" Categoria where idCategoria=" + idCat);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public CategoriaBean preactualizar(int idCat) throws Exception {
		CategoriaBean categoria = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idCat, nomCat " +
					"from categoria where idCat=" + idCat);
			if(rs.next()){
				categoria = new CategoriaBean();
				categoria.setIdCat( rs.getInt("idCat") );
				categoria.setNomCat( rs.getString("nomCat") );
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return categoria;
	}

	@Override
	public boolean agregar(CategoriaBean categoria) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into Categoria(descripcion) values('"+categoria.getNomCat()+"');");
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean editar(CategoriaBean categoria) throws Exception {
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("update categoria " +
					"set nomCat='"+categoria.getNomCat()+"' " +
					"where idCat="+ categoria.getIdCat());
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Vector<CategoriaBean> listar() throws Exception {
		Vector<CategoriaBean> categoria = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Categoria");
			
			categoria = new Vector<CategoriaBean>();
			CategoriaBean unbean = null;
			while(rs.next()){
				unbean = new CategoriaBean();
				unbean.setIdCat(rs.getInt(1));
				unbean.setNomCat(rs.getString(2));
				categoria.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return categoria;
	}

}
