package dao.interfaces;

import java.util.Vector;

import beans.CategoriaBean;

public interface CategoriaDao {
	
	public boolean eliminar(int idCat) throws Exception;

	public boolean agregar(CategoriaBean categoria) throws Exception;

	public boolean editar(CategoriaBean categoria) throws Exception;

	public Vector<CategoriaBean> listar() throws Exception;

	public CategoriaBean preactualizar(int idCat) throws Exception;
}
