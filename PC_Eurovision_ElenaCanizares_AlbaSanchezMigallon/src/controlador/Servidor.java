package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
			System.out.println("Arrancado el servidor");
			while (true) {
				try {
					Socket conexion = socketEscucha.accept();
					HiloVotante hilo = new HiloVotante(conexion);// crea hilo votante
					hilo.start();
					hilo.join();
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (null != socketEscucha) {
					socketEscucha.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
