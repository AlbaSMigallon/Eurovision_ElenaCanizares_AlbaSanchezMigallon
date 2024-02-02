package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import persistencias.Cantantes;
import persistencias.PorcentajesRangoedad;
import persistencias.ResultadosFaseNacional;

/**
 * Cada pais es un cliente. Creara un hilo por votante y gestionara la cantidad
 * segun rango de edad
 * 
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos
 *         Guerrero Caro
 * @version 1.0
 * @see Thread
 */
public class ClientePais extends Thread {
	/*
	 * Cada pais es un cliente. Creara un hilo por votante y gestionara la cantidad
	 * segun rango de edad
	 *
	 */
	// objeto obtenido de la consulta para calcular porcentajes por rango de edad
	private PorcentajesRangoedad porcentajes;
	// estructura de datos en la que se almacenaran los resultados de los votos que

	private HashMap<String, Integer> votaciones;
	private List<Cantantes> cantantes;
	private String cantanteVotoPrimero;
	private String cantanteVotoSegundo;
	private String cantanteVotoTercero;
	private ResultadosFaseNacional resultadosFaseNacional;
	private boolean esFinCliente;

	public ClientePais(PorcentajesRangoedad porcentajes, List<Cantantes> cantantes) {
		this.porcentajes = porcentajes;
		this.cantantes = cantantes;
		inicializarHashMap();// inicializamos hasmao con nombres de paises
		this.esFinCliente = false;
	}

	public boolean isEsFinCliente() {
		return esFinCliente;
	}

	public void setEsFinCliente(boolean esFinCliente) {
		this.esFinCliente = esFinCliente;
	}

	public ResultadosFaseNacional getResultadosFaseNacional() {
		return resultadosFaseNacional;
	}

	public void setResultadosFaseNacional(ResultadosFaseNacional resultadosFaseNacional) {
		this.resultadosFaseNacional = resultadosFaseNacional;
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

	public String getCantanteVotoPrimero() {
		return cantanteVotoPrimero;
	}

	public void setCantanteVotoPrimero(String cantanteVotoPrimero) {
		this.cantanteVotoPrimero = cantanteVotoPrimero;
	}

	public String getCantanteVotoSegundo() {
		return cantanteVotoSegundo;
	}

	public void setCantanteVotoSegundo(String cantanteVotoSegundo) {
		this.cantanteVotoSegundo = cantanteVotoSegundo;
	}

	public String getCantanteVotoTercero() {
		return cantanteVotoTercero;
	}

	public void setCantanteVotoTercero(String cantanteVotoTercero) {
		this.cantanteVotoTercero = cantanteVotoTercero;
	}

	public List<Cantantes> getCantantes() {
		return cantantes;
	}

	public void setCantantes(List<Cantantes> cantantes) {
		this.cantantes = cantantes;
	}

	private void fijarGanadores() {
		/*
		 * Fijamos los cantantes votados
		 */
		ArrayList<Integer> ganadores = new ArrayList<>(this.votaciones.values());
		Collections.sort(ganadores, Collections.reverseOrder());

		Map<Integer, List<String>> paisesPorPuntuacion = new HashMap<>();

		// agrupa los paises por puntuacion
		for (Entry<String, Integer> entrada : this.votaciones.entrySet()) {
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
				setCantanteVotoPrimero(paisesEmpatados.get(0));
			} else if (i == 1) {
				if (paisesEmpatados.get(0).equals(getCantanteVotoPrimero())) {
					setCantanteVotoSegundo(paisesEmpatados.get(1));
				} else {
					setCantanteVotoSegundo(paisesEmpatados.get(0));
				}

			} else if (i == 2) {
				if (paisesEmpatados.get(0).equals(getCantanteVotoPrimero())) {
					if (paisesEmpatados.get(0).equals(getCantanteVotoSegundo())) {
						setCantanteVotoTercero(paisesEmpatados.get(2));
					} else {
						setCantanteVotoTercero(paisesEmpatados.get(1));
					}
				} else {
					if (paisesEmpatados.get(0).equals(getCantanteVotoSegundo())) {
						setCantanteVotoTercero(paisesEmpatados.get(1));
					} else {
						setCantanteVotoTercero(paisesEmpatados.get(0));
					}

				}

			}
		}

		// Obtenemos los cantantes asociados a los paises ganadores
		// como en el enunciado pide que se vote a cantantes, lo hacemos por cantantes
		// en vez de paises
		for (int i = 0; i < cantantes.size(); i++) {
			if (cantantes.get(i).getPais().equals(getCantanteVotoPrimero())) {
				setCantanteVotoPrimero(cantantes.get(i).getNombre());
			}
			if (cantantes.get(i).getPais().equals(getCantanteVotoSegundo())) {
				setCantanteVotoSegundo(cantantes.get(i).getNombre());
			}
			if (cantantes.get(i).getPais().equals(getCantanteVotoTercero())) {
				setCantanteVotoTercero(cantantes.get(i).getNombre());
			}
		}

		System.out.println("Las votaciones en " + porcentajes.getNombrePais() + " son:");
		System.out.println("15 puntos para " + getCantanteVotoPrimero());
		System.out.println("10 puntos para " + getCantanteVotoSegundo());
		System.out.println("8 puntos para " + getCantanteVotoTercero());

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
				String voto = calcularVotosNacionales(this.porcentajes.getNombrePais(), "1825");
				this.votaciones.put(voto, this.votaciones.get(voto) + 1);// Aniadimos voto al
				// hashmap
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
				String voto = calcularVotosNacionales(this.porcentajes.getNombrePais(), "2640");
				this.votaciones.put(voto, this.votaciones.get(voto) + 1);// Aniadimos voto al
				// hashmap
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
				String voto = calcularVotosNacionales(this.porcentajes.getNombrePais(), "4165");
				this.votaciones.put(voto, this.votaciones.get(voto) + 1);// Aniadimos voto al
				// hashmap
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
				String voto = calcularVotosNacionales(this.porcentajes.getNombrePais(), "66");
				this.votaciones.put(voto, this.votaciones.get(voto) + 1);// Aniadimos voto al
				// hashmap
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
	private String calcularVotosNacionales(String pais, String rango) throws Exception {
		// Creacion de hilos votante
		HiloVotante hilo = new HiloVotante(pais, rango);// crea hilo votante
		hilo.start();
		hilo.join();

		return hilo.getVoto();

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	private void enviarVotosNacionales() throws Exception {
		Socket socket = null;
		ObjectOutputStream objectOutputStream = null;
		BufferedReader bufferedReader = null;

		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
			socket = new Socket();
			socket.connect(direccion);

			// Serializar el objeto resultadosNacionales y enviarlo al servidor
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(this.resultadosFaseNacional);
			objectOutputStream.flush();

			// Recibir la respuesta del servidor
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			bufferedReader = new BufferedReader(isr);
			String respuestaServidor = bufferedReader.readLine();
			System.out.println(respuestaServidor);
			this.esFinCliente = true;

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(objectOutputStream);
			close(socket);
			close(bufferedReader);
		}
	}

	private static void close(BufferedReader bufferedReader) {
		try {
			if (null != bufferedReader) {
				bufferedReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
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

	private static void close(ObjectOutputStream objectOutputStream) {
		try {
			if (null != objectOutputStream) {
				objectOutputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void inicializarHashMap() {

		// inicializamos el hashmap con los nombres de los paises que recuperamos de la
		// tabla cantantes
		// de esta manera, en vez de picarlos a mano, conseguimos una app dinamica. si
		// se insertan nuevos paises en la tabla o se eliminan, o se modifican los
		// existentes el programa seguirá funcionando
		this.votaciones = new HashMap<>();

		for (int i = 0; i < cantantes.size(); i++) {
			votaciones.put(cantantes.get(i).getPais(), 0);

		}
	}

	public void run() {
		// metodo inicial, llamado desde la calse VotacionNacional para calcular numero
		// de votantes por rango
		numeroVotos1825();
		numeroVotos2640();
		numeroVotos4165();
		numeroVotosMas66();

		// fija los ganadores por pais
		fijarGanadores();

		// enviamos el resultado al servidor de eurovision
		try {

			// System.out.println("PORCENTAJES: "+porcentajes);
			// construimos objeto para el insert
			this.resultadosFaseNacional = new ResultadosFaseNacional();
			this.resultadosFaseNacional.setPais(porcentajes.getNombrePais());
			this.resultadosFaseNacional.setCantantePrimero(cantanteVotoPrimero);
			this.resultadosFaseNacional.setCantanteSegundo(cantanteVotoSegundo);
			this.resultadosFaseNacional.setCantanteTercero(cantanteVotoTercero);
			// CAMBIAR: aqui enviar directamente el objeto
			// //////////////////////////////////////////////////////////////////////////////////
			enviarVotosNacionales();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
