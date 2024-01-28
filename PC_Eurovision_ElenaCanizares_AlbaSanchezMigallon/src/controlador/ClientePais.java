package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

import persistencias.PorcentajesRangoedad;
import persistencias.ResultadosFaseNacional;

public class ClientePais {
	/*
	 * Cada pais es un cliente. Enviara una peticion al servidor por votante. La
	 * petincion tendra en pais del votante y el rango de edad
	 * 
	 */

	// contruimos el objeto ResultadosFaseNacional para futuro insert
	private ResultadosFaseNacional resultadoNacional;
	// objeto obtenido de la consulta para calcular porcentajes por rango de edad
	private PorcentajesRangoedad porcentajes;
	// estructura de datos en la que se almacenaran los resultados de los votos que
	// posteriormente utilizaremos para hacer el insert
	private HashMap<String, Integer> votaciones;

	public ClientePais(PorcentajesRangoedad porcentajes) {
		this.porcentajes = porcentajes;
		this.resultadoNacional = new ResultadosFaseNacional();
		inicializarHashMap();// inicializamos hasmao con nombres de paises
	}

	public ResultadosFaseNacional getResultadoNacional() {
		return resultadoNacional;
	}

	public void setResultadoNacional(ResultadosFaseNacional resultadoNacional) {
		this.resultadoNacional = resultadoNacional;
	}

	public PorcentajesRangoedad getPorcentajes() {
		return porcentajes;
	}

	public void setPorcentajes(PorcentajesRangoedad porcentajes) {
		this.porcentajes = porcentajes;
	}

	public HashMap<String, Integer> getVotaciones() {
		return votaciones;
	}

	public void setVotaciones(HashMap<String, Integer> votaciones) {
		this.votaciones = votaciones;
	}

	private void fijarGanadores() {
		/*
		 * Fijamos los paises votados
		 */
		ArrayList<Integer> ganadores = new ArrayList<>(this.votaciones.values());
		Collections.sort(ganadores, Collections.reverseOrder());

		Map<Integer, List<String>> paisesPorPuntuacion = new HashMap<>();

		// agrupa los paises por puntuacion
		for (Entry<String, Integer> entrada : this.votaciones.entrySet()) {/////// error
			int puntuacion = entrada.getValue();
			paisesPorPuntuacion.computeIfAbsent(puntuacion, k -> new ArrayList<>()).add(entrada.getKey());
		}

		// resuelve los empates y fija los ganadores
		for (int i = 0; i < 3; i++) {
			int puntuacion = ganadores.get(i);
			List<String> paisesEmpatados = paisesPorPuntuacion.get(puntuacion);

			// si hay empate, decide el orden aleatoriamente
			if (paisesEmpatados.size() > 1) {
				Collections.shuffle(paisesEmpatados);
			}

			// fija el ganador segun la posicion
			if (i == 0) {
				this.resultadoNacional.setPaisPrimero(paisesEmpatados.get(0));
			} else if (i == 1) {
				if (paisesEmpatados.get(0).equals(this.resultadoNacional.getPaisPrimero())) {
					this.resultadoNacional.setPaisSegundo(paisesEmpatados.get(1));
				} else {
					this.resultadoNacional.setPaisSegundo(paisesEmpatados.get(0));
				}

			} else if (i == 2) {
				if (paisesEmpatados.get(0).equals(this.resultadoNacional.getPaisPrimero())) {
					if (paisesEmpatados.get(0).equals(this.resultadoNacional.getPaisSegundo())) {
						this.resultadoNacional.setPaisTercero(paisesEmpatados.get(2));
					} else {

					}
				} else {
					if (paisesEmpatados.get(0).equals(this.resultadoNacional.getPaisSegundo())) {
						this.resultadoNacional.setPaisTercero(paisesEmpatados.get(1));
					} else {
						this.resultadoNacional.setPaisTercero(paisesEmpatados.get(0));
					}

				}

			}

			this.resultadoNacional.setPais(this.porcentajes.getNombrePais());
		}

		System.out.println("Las votaciones en " + porcentajes.getNombrePais() + " son:");
		System.out.println("15 puntos para " + resultadoNacional.getPaisPrimero());
		System.out.println("10 puntos para " + resultadoNacional.getPaisSegundo());
		System.out.println("8 puntos para " + resultadoNacional.getPaisTercero());

	}

	private void numeroVotos1825() {
		/*
		 * Calculamos el numero de hilos que debemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3
		 */
		int numeroHilos = (int) ((Double.valueOf(this.porcentajes.getRango1825()) / 100)
				* Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			for (int i = 0; i < numeroHilos; i++) {
				calcularVotosNacionales(this.porcentajes.getNombrePais(), "1825");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void numeroVotos2640() {
		/*
		 * Calculamos el numero de hilos que debemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3
		 */
		int numeroHilos = (int) ((Double.valueOf(this.porcentajes.getRango2640()) / 100)
				* Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			for (int i = 0; i < numeroHilos; i++) {
				calcularVotosNacionales(this.porcentajes.getNombrePais(), "2640");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void numeroVotos4165() {
		/*
		 * Calculamos el numero de hilos que debemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3
		 */
		int numeroHilos = (int) ((Double.valueOf(this.porcentajes.getRango4165()) / 100)
				* Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			for (int i = 0; i < numeroHilos; i++) {
				calcularVotosNacionales(this.porcentajes.getNombrePais(), "4165");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void numeroVotosMas66() {
		/*
		 * Calculamos el numero de hilos que debemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3
		 */
		int numeroHilos = (int) ((Double.valueOf(this.porcentajes.getRangoMas66()) / 100)
				* Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			for (int i = 0; i < numeroHilos; i++) {
				calcularVotosNacionales(this.porcentajes.getNombrePais(), "66");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	private void calcularVotosNacionales(String pais, String rango) throws Exception {////////////////////////
		// Peticion al servidor
		Socket socket = null;
		BufferedReader bfr = null;
		PrintWriter pw = null;
		InputStreamReader isr = null;
		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
			socket = new Socket();
			socket.connect(direccion);
			// Escribe la peticion al servidor
			pw = new PrintWriter(socket.getOutputStream());
			pw.print(pais + "\n");// Nombre del pais
			pw.print(rango + "\n");// Rango edad

			pw.flush();

			// lee la respuesta del servidor
			isr = new InputStreamReader(socket.getInputStream());
			bfr = new BufferedReader(isr);
			String resultado = bfr.readLine();// respuesta
			// System.out.println("El resultado fue:" + resultado);
			this.votaciones.put(resultado, this.votaciones.get(resultado) + 1);

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pw);
			close(bfr);
			close(isr);
			close(socket);
		}
	}

	private static void close(Socket socket) {
		try {
			if (null != socket) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void close(Writer writer) {
		try {
			if (null != writer) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void close(Reader reader) {
		try {
			if (null != reader) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void inicializarHashMap() {
		this.votaciones = new HashMap<>();
		votaciones.put("Espania", 0);
		votaciones.put("Alemania", 0);
		votaciones.put("Francia", 0);
		votaciones.put("Italia", 0);
		votaciones.put("Portugal", 0);
		votaciones.put("Reino Unido", 0);
		votaciones.put("Polonia", 0);
		votaciones.put("Paises Bajos", 0);
		votaciones.put("Rumania", 0);
		votaciones.put("Grecia", 0);
	}

	public ResultadosFaseNacional iniciarCliente() {
		// metodo inicial, llamado desde la calse VotacionNacional para calcular numero
		// de votantes por rango
		numeroVotos1825();
		numeroVotos2640();
		numeroVotos4165();
		numeroVotosMas66();

		// fija los ganadores por pais
		fijarGanadores();

		// devolvemos el resultado de voto del pais a votacion nacional para el
		// posterior insert
		return this.resultadoNacional;
	}

}
