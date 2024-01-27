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
	 * Cada pais es un cliente. Enviará una peticion al servidor por cada rango de
	 * edad.
	 * 
	 */

	// contruimos el objeto ResultadosFaseNacional para futuro insert
	private ResultadosFaseNacional resultadoNacional;
	// objeto obtenido de la consulta para calcular porcentajes por rango de edad
	private PorcentajesRangoedad porcentajes;
	// estructura de datos en la que se almacenaran los resultados de los votos que
	// posteriormente utilizaremos para hacer el insert
	private HashMap<String, Integer> votaciones;

	public ClientePais() {
		super();
		this.resultadoNacional= new ResultadosFaseNacional();
		this.resultadoNacional.setPais(porcentajes.getNombrePais());// seteamos el nombre del pais en resultadoNacional
																	// con el nombre obtenido de la consulta de
																	// porcentajes
		inicializarHashMap();// inicializacion del HashMap con keys nombres de paises y values a 0 para ir
								// sumando
	}

	public ClientePais(PorcentajesRangoedad porcentajes) {
		this.porcentajes = porcentajes;
		this.resultadoNacional= new ResultadosFaseNacional();
		inicializarHashMap();
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

        // Agrupa los paises por puntuacion
        for (Entry<String, Integer> entrada : this.votaciones.entrySet()) {
            int puntuacion = entrada.getValue();
            paisesPorPuntuacion.computeIfAbsent(puntuacion, k -> new ArrayList<>()).add(entrada.getKey());
        }

        // Resuelve los empates y fija los ganadores
        for (int i = 0; i < 3; i++) {
            int puntuacion = ganadores.get(i);
            List<String> paisesEmpatados = paisesPorPuntuacion.get(puntuacion);

            // Si hay empate, decide el orden aleatoriamente
            if (paisesEmpatados.size() > 1) {
                Collections.shuffle(paisesEmpatados);
            }

            // Fija el ganador segun la posición
            if (i == 0) {
                this.resultadoNacional.setPaisPrimero(paisesEmpatados.get(0));
            } else if (i == 1) {
                this.resultadoNacional.setPaisSegundo(paisesEmpatados.get(0));
            } else if (i == 2) {
                this.resultadoNacional.setPaisTercero(paisesEmpatados.get(0));
            }
        }

        System.out.println("Las votaciones en " + porcentajes.getNombrePais() + " son:");
        System.out.println("15 puntos para " + resultadoNacional.getPaisPrimero());
        System.out.println("10 puntos para " + resultadoNacional.getPaisSegundo());
        System.out.println("8 puntos para " + resultadoNacional.getPaisTercero());
    
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

	private void numeroVotos1825() {
		/*
		 * Calculamos el numero de hilos que devemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3. Tras el calculo, llamamos al
		 * metodo calcularVotosNacionales que realiza la peticion al servidorF
		 */
		int numeroHilos = (int)((Double.valueOf(this.porcentajes.getRango1825()) / 100) * Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			calcularVotosNacionales(this.porcentajes.getNombrePais(), "1825", numeroHilos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void numeroVotos2640() {
		/*
		 * Calculamos el numero de hilos que devemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3. Tras el calculo, llamamos al
		 * metodo calcularVotosNacionales que realiza la peticion al servidorF
		 */
		int numeroHilos = (int)((Double.valueOf(this.porcentajes.getRango2640()) / 100) * Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			calcularVotosNacionales(this.porcentajes.getNombrePais(), "2640", numeroHilos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void numeroVotos4165() {
		/*
		 * Calculamos el numero de hilos que devemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3. Tras el calculo, llamamos al
		 * metodo calcularVotosNacionales que realiza la peticion al servidorF
		 */
		int numeroHilos = (int)((Double.valueOf(this.porcentajes.getRango4165()) / 100) * Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			calcularVotosNacionales(this.porcentajes.getNombrePais(), "4165", numeroHilos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void numeroVotosMas66() {
		/*
		 * Calculamos el numero de hilos que devemos crear por cada rango de edad y, si
		 * el numero de hilos es menor a 3, creamos 3. Tras el calculo, llamamos al
		 * metodo calcularVotosNacionales que realiza la peticion al servidorF
		 */
		int numeroHilos = (int)((Double.valueOf(this.porcentajes.getRangoMas66()) / 100) * Double.valueOf(porcentajes.getTotalHabitantes())) / 500000;
		if (numeroHilos < 3) {
			numeroHilos = 3;
		}
		try {
			calcularVotosNacionales(this.porcentajes.getNombrePais(), "66", numeroHilos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	private void calcularVotosNacionales(String pais, String rango, int numeroHilos) throws Exception {
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
			pw.print(numeroHilos + "\n");// Cantidad de hilos
			pw.flush();
			// lee la respuesta del servidor
			isr = new InputStreamReader(socket.getInputStream());
			bfr = new BufferedReader(isr);
			String resultado = bfr.readLine();
			System.out.println("El resultado fue:" + resultado);

			String[] resultadosRespuesta = resultado.split(";");// Dividimos el string concatenado por ';' para
																// quedarnos con el nombre de paises votados

			for (int i = 0; i < resultadosRespuesta.length; i++) {
				this.votaciones.put(resultadosRespuesta[i], this.votaciones.get(resultadosRespuesta[i])+1);// Aniadimos voto al
																									// hashmap
			}
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

	public ResultadosFaseNacional iniciarCliente() {
		// metodo inicial, llamado desde la calse VotacionNacional y que lanza una
		// peticion al servidor por cada rango de edad
		numeroVotos1825();
		numeroVotos2640();
		numeroVotos4165();
		numeroVotosMas66();

		fijarGanadores();
		// devolvemos el resultado de voto del pais
		return this.resultadoNacional;
	}

}
