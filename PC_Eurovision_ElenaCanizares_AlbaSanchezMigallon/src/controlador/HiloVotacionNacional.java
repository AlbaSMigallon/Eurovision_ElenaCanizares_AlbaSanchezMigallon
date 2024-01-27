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

public class HiloVotacionNacional extends Thread {
	/*
	 * Esta clase hilo actua como intermediario: escucha la peticion del cliente al
	 * servidor y lanza los hilos corresponcientes al numero de votantes por rango
	 * de edad. De esta manera evitamos enviar una peticion al servidor por votante,
	 * ya que puede dar problemas tener muchas peticiones. A su vez, en esta clase,
	 * tambien gestionamos la respuesta de los hilos votantes y la enviamos al
	 * cliente, quedando como resultado un String con el nombre de paises votados
	 * por cada votante separados por un ';'
	 */
	Socket socket;

	public HiloVotacionNacional(Socket socket) {
		this.socket = socket;
	}

	private void escuchar() {

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader bf = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			System.out.println("Conexion recibida");
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			bf = new BufferedReader(isr);
			String nombrePais = bf.readLine();
			String rangoEdad = bf.readLine();
			int numHilos = Integer.parseInt(bf.readLine());
			System.out.println("Pais: " +nombrePais + " - Rango: "+ rangoEdad+ " - Num hilos: "+ numHilos);
			String result = "";

			for (int i = 0; i < numHilos; i++) {

				try {
					// Creamos hilo, lanzamos, esperamos, concatenamos resultado, el hilo duerm
					HiloVotante votante = new HiloVotante(nombrePais, rangoEdad);
					votante.start();
					votante.join();
					if(result.equals("")) {
						result = votante.getVoto();
					}else  {
						result = result + ";" + votante.getVoto();// Concatenamos con un ';'
					}
					
					//Thread.sleep(200);// hilo duerme 0,2 segundos
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write(result.toString());
			pw.flush();
		} catch (IOException e) {
			System.out.println("Error al aceptar conexion " + e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			close(pw);
			close(os);
			close(bf);
			close(isr);
			close(is);
			try {
				if (null != socket) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
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

	public void run() {
		escuchar();
	}

}
