package socket.operacion.ataque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import socket.operacion.dto.MensajeSecretoDTO;
import socket.operacion.dto.RespuestaCoronelDTO;

public class ServidorTorreControl {

	public static final int PUERTO_ULTRASECRETO = 5544;
	private ServerSocket servidor = null;
	
	public static void main(String[] args) {
		try {
			new ServidorTorreControl().levantarServidor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void levantarServidor() throws Exception {
		
		servidor = new ServerSocket(PUERTO_ULTRASECRETO);
		System.out.println("TORRE DE CONTROL- ESCUCHANDO MENSAJE");
		
		Socket socket = servidor.accept();
		
		System.out.println("TORRE DE CONTROL - ESCUCHO UN MENSAJE");
		
		ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());
		
		MensajeSecretoDTO msg = (MensajeSecretoDTO)flujoEntrada.readObject();
		
		System.out.println("Id Soldado:"+ msg.getIdSoldado());
		System.out.println("Coordenadas:"+ msg.getCoordenadas());
		System.out.println("Mensaje:"+ msg.getMensaje());
		
		System.out.println("Las ordenes son:");
		Scanner entrada = new Scanner(System.in);
		
		RespuestaCoronelDTO respuesta = new RespuestaCoronelDTO("LAS ORDENES SON: "+entrada.nextLine(), "ALFA1");
		
		ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
		flujoSalida.writeObject(respuesta);
		
		socket.close();
	}
	
}
