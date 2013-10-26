package beans;

public class PuestoTrabajoListarBean {

	String Categoria;
	String Trabajo;
	String fechaInicio;
	String fechareg;
	int diasDis;
	float salario;
	String Moneda;
	int estado;
	String descripcion;
	int idPuestoTrabajo;
	
	public PuestoTrabajoListarBean(){
		Categoria="";
		Trabajo="";
		fechaInicio="";
		fechareg="";
		diasDis=0;
		salario=0;
		Moneda="";
		estado=0;
		descripcion="";
		idPuestoTrabajo=0;
		
		
	}

	public int getIdPuestoTrabajo() {
		return idPuestoTrabajo;
	}

	public void setIdPuestoTrabajo(int idPuestoTrabajo) {
		this.idPuestoTrabajo = idPuestoTrabajo;
	}

	public String getMoneda() {
		return Moneda;
	}

	public void setMoneda(String moneda) {
		Moneda = moneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public String getTrabajo() {
		return Trabajo;
	}

	public void setTrabajo(String trabajo) {
		Trabajo = trabajo;
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

	

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
