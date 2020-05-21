package socket.operacion.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MensajeSecretoDTO implements Serializable {

	private String idSoldado;
	private String coordenadas;
	private String mensaje;
	
	public String getIdSoldado() {
		return idSoldado;
	}
	public void setIdSoldado(String idSoldado) {
		this.idSoldado = idSoldado;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
