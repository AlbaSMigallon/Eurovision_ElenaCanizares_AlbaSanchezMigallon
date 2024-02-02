package controlador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import persistencias.ResultadosFaseNacional;

/**
 * Clase HiloEurovision que extiende la clase Thread 
 * Se encarga de recibir el objeto con la informacion de cada cliente pais para hacer el insert en la tabla de la Fase Nacional
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 * @see Thread
 */
public class HiloEurovision extends Thread {
	private Socket socket;
	//private ResultadosFaseNacional resultadosNacionales;
	//private GestionDeDatos gBD;
	

	public HiloEurovision(Socket socket) {
		this.socket = socket;
		//System.out.println("se crea un hiloEurovision");
		
	}

	public void run() {
		PrintWriter printWriter = null;
		 try {
	            // Recibir el objeto desde el cliente
	            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
	            ResultadosFaseNacional resultadosRecibidos = (ResultadosFaseNacional) objectInputStream.readObject();

	            System.out.println("Informacion recibida por el servidor: " + resultadosRecibidos.getPais()
	                    + " " + resultadosRecibidos.getCantantePrimero() + " " + resultadosRecibidos.getCantanteSegundo()
	                    + " " + resultadosRecibidos.getCantanteTercero());

	            // Realizar operaciones con resultadosRecibidos según sea necesario
	            GestionDeDatos gBD = GestionDeDatos.getInstance();
	           
	            gBD.insertResultadosFaseNacional(resultadosRecibidos);
	            
	            System.out.println(resultadosRecibidos);
	            
	         // Enviar respuesta al cliente y seteamos para indicar que este cliente ha terminado, paro luego gestionar el boton
	            printWriter = new PrintWriter(socket.getOutputStream(), true);
	            printWriter.println("Estamos ok");
	          

	            // Puedes enviar una respuesta al cliente si es necesario
	            // (por ejemplo, usando un PrintWriter en el socket.getOutputStream())




		} catch (IOException e) {
			System.out.println("Error al aceptar conexion "+e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(printWriter);
			close(socket);
		}


	}

	private void close(Socket socket) {
		try {
			if (null != socket) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close(PrintWriter printWriter) {
		if (null != socket) {
			printWriter.close();
		}
	}

	
}
