package beans;

public class PuestoTrabajoBean {
	
	int idCategoria;
	int idTrabajo;
	int idPuestoTrabajo;
	String fechaInicio;
	String fechareg;
	int diasDis;
	float salario;
	int idMoneda;
	int estado;
	String descripcion;
	
	public PuestoTrabajoBean(){
		idCategoria=0;
		idTrabajo=0;
		idPuestoTrabajo=0;
		fechaInicio="i";
		fechareg="r";
		diasDis=0;
		salario=0;
		idMoneda=0;
		estado=0;
		descripcion="d";
		
	}
	
	
	
	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



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
	public int getIdPuestoTrabajo() {
		return idPuestoTrabajo;
	}
	public void setIdPuestoTrabajo(int idPuestoTrabajo) {
		this.idPuestoTrabajo = idPuestoTrabajo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechareg() {
		return fechareg;
	}
	public void setFechareg(String fechareg) {
		this.fechareg = fechareg;
	}
	public int getDiasDis() {
		return diasDis;
	}
	public void setDiasDis(int diasDis) {
		this.diasDis = diasDis;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}
