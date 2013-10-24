package dao.interfaces;

import java.util.Vector;

import beans.ServicioBean;


public interface ServicioDao {

	public boolean eliminar(int id) throws Exception;
	
	public boolean agregar(ServicioBean servicio) throws Exception;
	
	public Vector<ServicioBean> listar() throws Exception;
	
	public ServicioBean preactualizar(int id) throws Exception;
	
	public boolean actualizar(ServicioBean servicio) throws Exception;
}
