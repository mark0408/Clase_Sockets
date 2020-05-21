package socket.operacion.servicio;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import socket.operacion.entidad.Libro;
import socket.operation.dto.MensajeDTO;

public class Cliente {

	public static final int PUERTO_ULTRASECRETO = 5544;
	public static void main(String[] args) {
		try {
			MensajeDTO resp = new MensajeDTO();
			ArrayList<Libro> lista = new ArrayList<Libro>();
			System.out.println("Cliente - INTENTANDO COMUNICARSE...");
			
			Socket socket = new Socket("localhost", PUERTO_ULTRASECRETO);
			
			ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("PREPARANDO EL ENVIO DEL MENSAJE...");
			
			Libro lib = new Libro();
			//Scan
			System.out.println("");
			System.out.println("||||--- Registre 4 libros ---||||");
			System.out.println("");
			Scanner entrada = new Scanner(System.in);
			for (int i = 1; i < 5; i++) {
				entrada = new Scanner(System.in);
				lib = new Libro();
				lib.setCodigo(i);
				System.out.print("Ingrese titulo: ");
				lib.setTitulo(entrada.nextLine());
				System.out.println("");
				System.out.println("Origen => 0: extranjero  1: nacional");
				System.out.print("Ingrese origen: ");
				lib.setOrigen((entrada.nextInt() ==0)?true:false);
				lista.add(lib);
				System.out.println("");
			}
			entrada.close();
			//
			resp.setLista(lista);
			
			flujoSalida.writeObject(resp);
			System.out.println("");
			System.out.println("FIN DEL MENSAJE");
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
