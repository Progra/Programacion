package dao.interfaces;

import java.util.Vector;

import beans.PuestoTrabajoBean;
import beans.PuestoTrabajoListarBean;



public interface PuestoTrabajoDAO {

	public boolean eliminar(int idPuesto) throws Exception;

	public boolean agregar(PuestoTrabajoBean puesto) throws Exception;

	public boolean editar(PuestoTrabajoBean pusto) throws Exception;

	public Vector<PuestoTrabajoListarBean> listar() throws Exception;
}
