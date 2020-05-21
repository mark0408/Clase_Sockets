package socket.operacion.servicio;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import socket.operacion.entidad.Libro;
import socket.operation.dto.MensajeDTO;

public class Servidor {

	public static final int PUERTO_ULTRASECRETO = 5544;
	private ServerSocket servidor = null;
	
	public static void main(String[] args) {
		try {
			new Servidor().levantarServidor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void levantarServidor() throws Exception {
		
		servidor = new ServerSocket(PUERTO_ULTRASECRETO);
		System.out.println("SERVIDOR - ESCUCHANDO MENSAJE");
		
		Socket socket = servidor.accept();
		
		System.out.println("SERVIDOR - ESCUCHO UN MENSAJE");
		
		ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());
		
		MensajeDTO msg = (MensajeDTO)flujoEntrada.readObject();
		int librosNacional =0;
		int librosExtranjero=0;
		for (Libro libro : msg.getLista()) {
			String origen = "Nacional";
			librosNacional++;
			if(libro.getOrigen()) {
				origen="Extranjero";
				librosExtranjero++;
				librosNacional--;
			}
				
			System.out.println("");
			System.out.println("Id Libro:"+ libro.getCodigo());
			System.out.println("Titulo:"+ libro.getTitulo());
			System.out.println("Tipo:"+ origen);
			System.out.println("");
		}
		System.out.println("----------------------------");
		System.out.println("----------------------------");
		System.out.println("Cantidad de libros de origen extranjero : "+ librosExtranjero);
		System.out.println("Cantidad de libros de origen nacional : " + librosNacional);
		System.out.println("");
		System.out.println("SERVIDOR - FIN DEL MENSAJE");
		socket.close();
	}
	
}
