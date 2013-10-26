package beans;

public class TipoTrabajoBean {
	 int idCategoria;
	 int idTrabajo;
	 String TipoTrabajo;
	 
	 
	 public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public int getIdTrabajo() {
		return idTrabajo;
	}


	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}


	public String getTipoTrabajo() {
		return TipoTrabajo;
	}


	public void setTipoTrabajo(String tipoTrabajo) {
		TipoTrabajo = tipoTrabajo;
	}


	public TipoTrabajoBean(){
		 idCategoria=0;
		  idTrabajo=0;
		  TipoTrabajo="";
		 
	 }
}
