package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Servidor establece un servidor que escucha en el puerto 9876, acepta conexiones entrantes de clientes y crea
 * un hilo (HiloEurovision) para manejar la comunicacion con cada cliente de forma concurrente
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 */
public class Servidor {

	public static void main(String[] args) throws Exception {
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
			System.out.println("Arrancado el servidor");
			while (true) {
				try {
					Socket conexion = socketEscucha.accept();
					HiloEurovision hilo = new HiloEurovision(conexion);// crea hilo votante
					hilo.start();
					//hilo.join();
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
