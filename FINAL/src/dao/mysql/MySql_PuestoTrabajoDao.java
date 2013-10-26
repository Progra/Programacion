package dao.mysql;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import beans.PuestoTrabajoBean;
import beans.PuestoTrabajoListarBean;
import dao.interfaces.PuestoTrabajoDAO;
import daofactory.MySqlDAOFactory;

public class MySql_PuestoTrabajoDao extends MySqlDAOFactory implements PuestoTrabajoDAO{
	
	@Override
	public boolean eliminar(int idPuesto) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from PuestoTrabajo where idPuestoTrabajo="+idPuesto);
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public boolean agregar(PuestoTrabajoBean puesto) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into PuestoTrabajo ("
					+ "idCategoria,idTrabajo,fechInicio,fechReg,diasDis,salario,idMoneda, estado,descripcion)"
					+ "values("+puesto.getIdCategoria()+","+puesto.getIdTrabajo()+",'"+
					puesto.getFechaInicio()+"',CURDATE(),"+puesto.getDiasDis()+","+
					puesto.getSalario()+","+puesto.getIdMoneda()+","+puesto.getEstado()+",'"+puesto.getDescripcion()+"')");
			/*int filas = stmt.executeUpdate("insert into PuestoTrabajo (idCategoria,idTrabajo, fechInicio ,fechReg,diasDis,salario,idMoneda,estado,descripcion) values(1,1,'2013-10-10','2013-10-10',5,1000,1,1,'ninguna');");
			*/
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public boolean editar(PuestoTrabajoBean categoria) throws Exception{
		return false;
		
	}
	
	@Override
	public Vector<PuestoTrabajoListarBean> listar() throws Exception{
		Vector<PuestoTrabajoListarBean> puestos = new Vector<PuestoTrabajoListarBean>();
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("select C.descripcion , T.tipoTrabajo, P.fechInicio, P.fechReg, P.diasDis, P.salario, M.descripcion, P.estado, P.descripcion, P.idPuestoTrabajo from PuestoTrabajo P "
							+"inner join Trabajo T on  P.idTrabajo=T.idTrabajo and P.idCategoria=T.idCategoria "
							+"inner join Categoria C on T.idCategoria=C.idCategoria "
							+"inner join TipoMoneda M on P.idMoneda=M.idMoneda; " );
			
			PuestoTrabajoListarBean puesto=null;
			while(rs.next()){
				puesto= new PuestoTrabajoListarBean();
				puesto.setCategoria(rs.getString(1));
				puesto.setTrabajo(rs.getString(2));
				puesto.setFechaInicio(rs.getString(3));
				puesto.setFechareg(rs.getString(4));
				puesto.setDiasDis(rs.getInt(5));
				puesto.setSalario(rs.getFloat(6));
				puesto.setMoneda(rs.getString(7));
				puesto.setEstado(rs.getInt(8));
				puesto.setDescripcion(rs.getString(9));
				puesto.setIdPuestoTrabajo(rs.getInt(10));
				
				puestos.add(puesto);
				
				
			}	
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return puestos;
	}

}
