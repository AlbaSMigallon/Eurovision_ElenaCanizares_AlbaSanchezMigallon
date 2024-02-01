package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import persistencias.ResultadosFaseNacional;

/**
 * Clase HiloEurovision que extiende la clase Thread y representa un hilo de ejecucion que maneja la comunicacion con un
 * cliente
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 * @see Thread
 */
public class HiloEurovision extends Thread {
	Socket socket;
	ResultadosFaseNacional resultadosNacionales;
	GestionDeDatos gBD;

	public HiloEurovision(Socket socket) {
		this.socket = socket;
		System.out.println("se crea un hiloEurovision");
	}

	public void run() {
		// recibe la informacion del cliente
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader bf = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			bf = new BufferedReader(isr);
			String pais = bf.readLine();
			String cantantePrimero = bf.readLine();
			String cantanteSegundo = bf.readLine();
			String cantanteTercero = bf.readLine();

			System.out.println("Informacion recibida por el servidor: "+pais+" "+cantantePrimero+" "+cantanteSegundo+" "+cantanteTercero);

			resultadosNacionales= new ResultadosFaseNacional();
			resultadosNacionales.setPais(pais);
			resultadosNacionales.setCantantePrimero(cantantePrimero);
			resultadosNacionales.setCantanteSegundo(cantanteSegundo);
			resultadosNacionales.setCantanteTercero(cantanteTercero);

			GestionDeDatos gBD= GestionDeDatos.getInstance();
			System.out.println("antes del insert");
			gBD.insertResultadosFaseNacional(resultadosNacionales);

			// contesta a cliente, que no esta bonito dejarle en visto////////////////////////////////////////////////////////////

			//gBD.cerrarPoolConexiones();

		} catch (IOException e) {
			System.out.println("Error al aceptar conexion "+e.getMessage());
			e.printStackTrace();
		}finally {
			close(pw);
			close(os);
			close(bf);
			close(isr);
			close(is);
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

	private void close(Reader reader) {
		try {
			if (null != reader) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close(InputStream input) {
		try {
			if (null != input) {
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close(OutputStream output) {
		try {
			if (null != output) {
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close(Writer writer) {
		try {
			if (null != writer) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
