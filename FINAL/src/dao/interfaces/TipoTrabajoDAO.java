package dao.interfaces;

import java.util.Vector;

import beans.TipoTrabajoBean;


public interface TipoTrabajoDAO {

	public boolean eliminar(int idTipo, int idCat) throws Exception;

	public boolean agregar(TipoTrabajoBean Trabajo) throws Exception;

	public boolean editar(TipoTrabajoBean Trabajo) throws Exception;

	public Vector<TipoTrabajoBean> listar() throws Exception;
	
}
