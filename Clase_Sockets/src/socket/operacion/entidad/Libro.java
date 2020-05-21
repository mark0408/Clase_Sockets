package socket.operacion.entidad;

import java.io.Serializable;

public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5804927276290172569L;
	private int codigo;
	private String titulo;
	private Boolean origen;
	
	public Libro() {
	}
	
	public Libro(int codigo, String titulo, Boolean origen) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.origen = origen;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Boolean getOrigen() {
		return origen;
	}
	public void setOrigen(Boolean origen) {
		this.origen = origen;
	}


}
