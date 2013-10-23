package dao.mysql;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import dao.interfaces.MonedaDao;
import daofactory.MySqlDAOFactory;
import beans.MonedaBean;


public class MySql_MonedaDao extends MySqlDAOFactory implements MonedaDao {

	@Override
		public Vector<MonedaBean> listar() throws Exception {
			// TODO Auto-generated method stub
		
		
		Vector<MonedaBean> monedas = new Vector<MonedaBean>();
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("select * from TipoMoneda;");
			
			
			while(rs.next()){
				
				MonedaBean moneda= new MonedaBean();
				moneda.setIdTipoMoneda(rs.getInt(1));
				moneda.setNomMoneda(rs.getString(2));
				
				monedas.add(moneda);
				
			
			}	
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return monedas;
		
		
			
		}

	
	
	
}
