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
import java.util.Random;

public class HiloVotante extends Thread {
	Socket socket;

	public HiloVotante(Socket socket) {
		this.socket = socket;
	}

	/*
	 * Esta clase hilo se encarga de determinar el voto teniendo en cuenta la franja
	 * de edad y el filtro de no votar al pais de procedencia del voto
	 */
	private String voto;
	private String rangoEdad;
	private String pais;

	public HiloVotante(String pais, String rangoEdad) {
		this.rangoEdad = rangoEdad;
		this.pais = pais;

	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public String getRangoEdad() {
		return rangoEdad;
	}

	public void setRangoEdad(String rangoEdad) {
		this.rangoEdad = rangoEdad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
			this.pais = bf.readLine();
			this.rangoEdad = bf.readLine();

			System.out.println("Pais: " + this.pais + " - Rango: " + this.rangoEdad);
			String result = "";

			generarRandom();// genera resultado del voto

			result = this.getVoto();// extrae el voto y lo carga en el result

			//Thread.sleep(200);// hilo duerme 0,2 segundos/////////////////////////////////////////////////////////////////////////////////////

			// envia el resultado
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write(result.toString());
			pw.flush();
		} catch (IOException e) {
			System.out.println("Error al aceptar conexion " + e.getMessage());
			e.printStackTrace();
			return;
		} /*catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ finally {
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
		// generarRandom();

	}

	private void generarRandom() {
		/*
		 * Genera random para voto y en funcion de la edad del votante determina segun
		 * intencion de voto porporcionada
		 */
		int random = (int) (0 + (Math.random() * 100));

		switch (this.getRangoEdad()) {
		case "1825":
			this.voto = obtenerResultado1825(random);
			break;
		case "2640":
			this.voto = obtenerResultado2640(random);
			break;
		case "4165":
			this.voto = obtenerResultado4165(random);
			break;
		case "66":
			this.voto = obtenerResultado66(random);
			break;

		}
	}

	private String obtenerResultado1825(int random) {
		/*
		 * intencion de voto rango 18-25
		 */

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}

			random = (int) (0 + (Math.random() * 100));
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

	private String obtenerResultado2640(int random) {
		/*
		 * intencion de voto rango 26-40
		 */

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}

			random = (int) (0 + (Math.random() * 100));
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

	private String obtenerResultado4165(int random) {
		/*
		 * intencion de voto rango 41-65
		 */

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}

			random = (int) (0 + (Math.random() * 100));
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

	private String obtenerResultado66(int random) {
		/*
		 * intencion de voto rango +65
		 */

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}

			random = (int) (0 + (Math.random() * 100));
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

}
