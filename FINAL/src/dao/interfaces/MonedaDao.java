package dao.interfaces;

import java.util.Vector;

import beans.MonedaBean;

public interface MonedaDao {

	public boolean eliminar(int idMoneda) throws Exception;
	
	public boolean agregar(MonedaBean moneda) throws Exception;
	
	public Vector<MonedaBean> listar() throws Exception;
	
}
