package dao.interfaces;

import java.util.Vector;

import beans.PuestoBean;

public interface PuestoDao {
	public boolean eliminar(int idPTrab) throws Exception;

	public boolean agregar(PuestoBean puesto) throws Exception;

	public boolean editar(PuestoBean puesto) throws Exception;

	public Vector<PuestoBean> aaa() throws Exception;

}
