package socket.operation.dto;

import java.io.Serializable;
import java.util.ArrayList;
import socket.operacion.entidad.Libro;


public class MensajeDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1078866951297998939L;
	private ArrayList<Libro> lista;

	
	public ArrayList<Libro> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Libro> lista) {
		this.lista = lista;
	}
	
	
	
}
