package dao.interfaces;

import java.util.Vector;
import beans.MonedaBean;

public interface MonedaDao {

	
	public Vector<MonedaBean> listar() throws Exception;
	
}
