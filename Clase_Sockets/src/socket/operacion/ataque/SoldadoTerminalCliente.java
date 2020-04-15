package socket.operacion.ataque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import socket.operacion.dto.MensajeSecretoDTO;
import socket.operacion.dto.RespuestaCoronelDTO;

public class SoldadoTerminalCliente {

	public static final int PUERTO_ULTRASECRETO = 5544;
	public static void main(String[] args) {
		try {
			
			System.out.println("SOLDADO DELTA 1 - INTENTANDO COMUNICARSE...");
			
			Socket socket = new Socket("localhost", PUERTO_ULTRASECRETO);
			
			ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("PREPARANDO EL ENVIO DEL MENSAJE...");
			
			Scanner entrada = new Scanner(System.in);
			
			MensajeSecretoDTO mensaje = new MensajeSecretoDTO("Delta 1","LTN54.545.44",entrada.nextLine());
			
			flujoSalida.writeObject(mensaje);

			System.out.println("MENSAJE ENVIADO.. ESPERANDO RESPUESTA...");
			
			ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());
			
			RespuestaCoronelDTO msg = (RespuestaCoronelDTO)flujoEntrada.readObject();
			
			System.out.println("Id Coronel:"+ msg.getIdCoronel());
			System.out.println("Mensaje:"+ msg.getMensaje());
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
