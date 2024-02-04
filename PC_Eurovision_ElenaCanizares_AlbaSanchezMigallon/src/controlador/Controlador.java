package controlador;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import persistencias.Cantantes;
import persistencias.ResultadosEurovision;
import persistencias.ResultadosFaseNacional;
import vista.Vista;

/**
 * Clase que actua como el controlador principal en un patron de diseño
 * modelo-vista-controlador
 * 
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos
 *         Guerrero Caro
 * @version 1.0
 * @see ActionListener
 *
 */
public class Controlador implements ActionListener {
	// Instancia que ofrece la interfaz grafica de usuario
	private static Vista vista;
	// Instancia unica que encapsula toda la funcionalidad respectiva al acceso y
	// manipulacion de la base de datos "CENSO_EUROPA"
	private static GestionDeDatos gBD;
	// Instancias de la clase Timer que controlaran el tiempo asignado para la
	// gestion de un gif y un JButton respectivamente
	private static Timer timerCronometro;
	// Lista que almacena todos los objetos de tipo "ResultadosFaseNacional"
	// buscados de la tabla "RESULTADOS_FASE_NACIONAL"
	private static List<ResultadosFaseNacional> listaResultadosFaseNacional;
	// Valores numericos para el control del tiempo asignados a las respectivas
	// instancias Timer "timerCronometro" y "timerVotaciones"
	private static int tiempoTransicion;
	// Instancia hilo que creara los procesos necesarios en el calculo de los votos
	// por franjas de edad
	private VotacionNacional votacionNacional;
	// Diccionario en el que se ira almacenante cada pais y los votos que recibe,
	// utilizado para jugar con el ranking
	private Map<String, Integer> diccionarioPaisesPuntos;
	// Indice que se ira incrementando y utilizado en cada proceso de votacion para
	// acceder al ResultadoFaseNacion oportuno
	private int indiceListaResultadosNacionales;
	// Booleanos que controlan las perspectivas con las que juega el JButton
	// "btnVolver" para controlar a que JPanel volver
	private boolean panel1_activo, panel2_activo, panel3_activo, panel4_activo;
	// Variable donde se guardara el nombre del pais ganador de Eurovision
	private String paisGanador;

	private int contadorCarrusel = 1;

	/**
	 * Constructor de la clase "Controlador"
	 */
	public Controlador() {
		// Inicializacion de los atributos de instancia anteriores
		Controlador.vista = new Vista();
		Controlador.listaResultadosFaseNacional = new ArrayList<>();
		Controlador.gBD = GestionDeDatos.getInstance();
		Controlador.listaResultadosFaseNacional = new ArrayList<>();
		Controlador.tiempoTransicion = 2;
		this.votacionNacional = new VotacionNacional(vista);
		this.diccionarioPaisesPuntos = new HashMap<>();
		this.panel1_activo = true;
		this.panel2_activo = false;
		this.panel3_activo = false;
		this.panel4_activo = false;
		this.indiceListaResultadosNacionales = 0;
		this.paisGanador = "";

		// Asignamos escuchadores a los JButton
		Controlador.vista.btnComenzarInicio.addActionListener(this);
		Controlador.vista.btnComenzarVotaciones.addActionListener(this);
		Controlador.vista.btnRefrescarInfo.addActionListener(this);
		Controlador.vista.btnVolver.addActionListener(this);

		Controlador.vista.btnCarruselAnterior.addActionListener(this);
		Controlador.vista.btnCarruselSiguiente.addActionListener(this);
		
		// Asignamos escuchador al JMenuItem
		vista.itemMenuInformacion.addActionListener(this);

		// Vaciamos de registros la tabla "RESULTADOS_FASE_NACIONAL"
		gBD.deleteResultadosFaseNacional();

		// Mostramos la imagen del ganador anterior en el JPanel inicial
		mostrarImagenGanadorAnterior();

		// Iniciamos la votacion nacional desde el inicio del programa
		votacionNacional.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Acciones a realizar al pulsar el JButton "btnComenzarInicio"
		if (e.getSource() == vista.btnComenzarInicio) {
			vista.btnComenzarInicio.setVisible(false);
			// Se actualizan los booleanos que controlan la perspectiva en la que se
			// encuentra el usuario
			this.panel1_activo = false;
			this.panel3_activo = false;
			this.panel4_activo = false;
			this.panel2_activo = true;

			// Le asignamos un archivo .gif al JLabel "lblLogoInicio".
			vista.lblLogoInicio.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/introEuroGif.gif"));

			// Se inicia el Timer que controla el tiempo del gif de transicion entre el
			// primer JPanel y el segundo
			iniciarCronometroTransicion();

			// Se inicia el Timer que controla el tiempo hasta la disponibilidad del JButon
			// "btnComenzarVotaciones"
			// iniciarCronometroVotacionesEurovision();
		}

		// Acciones a realizar al pulsar el JButton "btnComenzarVotaciones"
		else if (e.getSource() == vista.btnComenzarVotaciones) {
			reproducirSonido(System.getProperty("user.dir") + "/resources/taylor/inAFewSeconds_join.wav");
			// Se actualizan los booleanos que controlan la perspectiva en la que se
			// encuentra el usuario
			this.panel1_activo = false;
			this.panel2_activo = false;
			this.panel4_activo = false;
			this.panel3_activo = true;

			// Hacemos visible el segundo JPanel y ocula
			vista.panelVotacionesNacionales.setVisible(false);
			vista.panelVotaciones.setVisible(true);

			// Cargamos la JList "listaResultadosFaseNacional"
			listaResultadosFaseNacional = gBD.getResultadosFaseNacional();
			vista.btnRefrescarInfo.setText("COMENZAR");
		}
		// Acciones a realizar al pulsar el JButton "btnRefrescarInfo"
		else if (e.getSource() == vista.btnRefrescarInfo) {
			
			// Controlamos que texto tiene el JButton "btnRefrescarInfo" para saber cuando
			// es el primer clic
			if (vista.btnRefrescarInfo.getText().equals("COMENZAR")) {
				reproducirSonido(System.getProperty("user.dir") + "/resources/taylor/pointsGoTo.wav");
				// Hacemos visibles los JPanel que tienen las banderas y los paises con sus
				// puntos
				vista.panelBanderas.setVisible(true);
				vista.panelPaisesPuntos.setVisible(true);
				vista.lblApano.setVisible(true);
				vista.lblApano2.setVisible(true);
				vista.lblApano3.setVisible(true);
				vista.lblApano4.setVisible(true);
				vista.lblApano5.setVisible(true);
				vista.lblApano6.setVisible(true);
				vista.lblApano7.setVisible(true);
				vista.lblApano8.setVisible(true);
				vista.lblApano9.setVisible(true);
				vista.lblApano10.setVisible(true);
				vista.textAreaPrueba.setVisible(true);
				// En el primer clic el texto del JButton "btnRefrescarInfo" cambia al primer
				// nombre de la lista "listaResultadosFaseNacional"
				vista.btnRefrescarInfo.setText(listaResultadosFaseNacional.get(0).getPais());

				// En el primer clic cargamos los nombres de los paises participantes y sus
				// puntos inicialmente 0 el mapa "diccionarioPaisesPuntos"
				cargarDiccionario();

				// En el primer clic ya cargamos la informacion del mapa en los labels, con
				// puntos 0 aun
				cargarJLabels();
			} else {
				// Obtenemos el tamanio de "listaResultadosFaseNacional" para usarlo como
				// indicativo del numero de clics necesarios en la votacion
				int tamanio = listaResultadosFaseNacional.size() - 1;

				/*
				 * Tras el primer clic se empiezan a sumar los puntos asignados a cada pais y se
				 * muestra la informacion Se hara uso de metodos privados para actualizar el
				 * diccionario ordenarlo e incrementar el indice
				 * "indiceListaResultadosNacionales"
				 */
				mostrarSiguienteResultado(tamanio);
			}
			/*
			 * Si el texto del JButton "btnRefrescarInfo" ha cambiado, significara que la
			 * votacion ha terminado y el insert en la tabla "RESULTADOS_EUROVISION" se ha
			 * realizado, teniendo a su vez un ganador designado
			 */
			if (vista.btnRefrescarInfo.getText().equals("ACTUACION GANADORA")) {
				// Se actualizan los booleanos que controlan la perspectiva en la que se
				// encuentra el usuario
				this.panel1_activo = false;
				this.panel2_activo = false;
				this.panel3_activo = false;
				this.panel4_activo = true;
				// Hacemos visible el JPanel "panelFinal" y hacemos invisible el JPanel
				// "panelVotaciones"
				vista.panelVotaciones.setVisible(false);
				vista.panelFinal.setVisible(true);
				// Traza para comprobar otro ganador
				// this.paisGanador = "Espania";
				// Mostramos en el ultimo JPanel "panelFinal" el nombre del pais ganador
				vista.lblPaisGanador.setText(this.paisGanador);
				// Mostramos el gif ganaodr con el metodo "mostrarGifGanadorFinal"
				mostrarGifGanadorFinal(this.paisGanador);
				// Buscamos al cantante ganador por el nombre del pais para hacer uso del nombre
				// del ganador y su cancion
				Cantantes cantanteGanador = gBD.getCantantePorPais(this.paisGanador);
				// Mostramos el nombre del cantante ganador
				vista.lblNombreGanador.setText(cantanteGanador.getNombre());
				// Mostramos el nombre de la cancion ganadora
				vista.lblCancionGanador.setText("Cancion: " + cantanteGanador.getNombreCancion());
				gBD.cerrarPoolConexiones();
			}
		}
		// Acciones a realizar al pulsar el JItemMenu "itemMenuInformacion"
		else if (e.getSource() == vista.itemMenuInformacion) {
			// Cambia la perspectiva haciendo uso del metodo "getPerspectivaAutoria" jugando
			// con la visibilidad de los JPanel
			getPerspectivaAutoria();
		}
		// Acciones a realizar al pulsar el JButton "btnVolver"
		else if (e.getSource() == vista.btnVolver) {
			/*
			 * Se controla mediante booleanos atributos de instancia a que JPanel ha de
			 * volverse desde la perspectiva asociada al JItemMenu "itemMenuInformacion"
			 */
			if (this.panel1_activo == true) {
				vista.panelAutoria.setVisible(false);
				vista.panelInicial.setVisible(true);
			} else if (this.panel2_activo == true) {
				vista.panelAutoria.setVisible(false);
				vista.panelVotacionesNacionales.setVisible(true);
			} else if (this.panel3_activo == true) {
				vista.panelAutoria.setVisible(false);
				vista.panelVotaciones.setVisible(true);
			} else if (this.panel4_activo == true) {
				vista.panelAutoria.setVisible(false);
				vista.panelFinal.setVisible(true);
				vista.lblActuacionGanador.setVisible(true);
			}
		}

		/*-------CARRUSEL-------*/
		else if (e.getSource() == vista.btnCarruselSiguiente) {
			if (contadorCarrusel >= 7) {
				contadorCarrusel = 1;
			} else {
				contadorCarrusel++;
			}

		} // FIN CARRUSEL SIGUIENTE
		else if (e.getSource() == vista.btnCarruselAnterior) {
			if (contadorCarrusel <= 1) {
				contadorCarrusel = 7;
			} else {
				contadorCarrusel--;
			}

		} // FIN CARRUSEL ANTERIOR

		/*
		 * vista.imagenCarrusel = new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/" + contadorCarrusel + ".gif");
		 * vista.lblCarrusel.setIcon(vista.imagenCarrusel);
		 */

		// Load the GIF
		String gifPath = System.getProperty("user.dir") + "/resources/actuaciones/" + contadorCarrusel + ".gif";
		vista.imagenCarrusel = new ImageIcon(gifPath);

		// Resize the GIF to fit the JLabel
		Image img = vista.imagenCarrusel.getImage();
		Image newImg = img.getScaledInstance(vista.lblCarrusel.getWidth(), vista.lblCarrusel.getHeight(),
				Image.SCALE_DEFAULT);
		vista.imagenCarrusel = new ImageIcon(newImg);

		vista.lblCarrusel.setIcon(vista.imagenCarrusel);

		/*-------FIN CARRUSEL-------*/
	}

	/**
	 * Funcionalidad que carga el nombre de los paises participantes encontrados en
	 * la lista "listaResultadosFaseNacional" y los puntos iniciales 0 en el
	 * diccionario atributo de instancia "diccionarioPaisesPuntos"
	 */
	private void cargarDiccionario() {
		// Se recorre la lista "listaResultadosFaseNacional" y se van anadiendo los
		// items al diccionario
		for (ResultadosFaseNacional r : Controlador.listaResultadosFaseNacional) {
			this.diccionarioPaisesPuntos.put(r.getPais(), 0);
		}
	}

	/**
	 * Funcionalidad que suma los puntos pasados como parametro a los existentes
	 * asociados a un pais
	 * 
	 * @param nombrePais
	 * @param puntos
	 */
	private void actualizarDiccionario(String nombrePais, int puntos) {
		/*
		 * Se recorre el diccionario, se controla que la clave coincida con el nombre
		 * del pais pasado como parametro y en tal caso se suman los puntos que ya tenia
		 * ese item a los puntos pasados como parametro
		 */
		for (String clavePais : this.diccionarioPaisesPuntos.keySet()) {
			int valorPuntos = this.diccionarioPaisesPuntos.get(clavePais);
			if (clavePais.equals(nombrePais)) {
				this.diccionarioPaisesPuntos.put(clavePais, valorPuntos + puntos);
			}
		}
	}

	/**
	 * Funcionalidad que carga la informacion que va actualizandose en el
	 * diccionario en los JLabels del JPanel "panelPaisesPuntos". Hace uso del
	 * metodo "ordenarMapaDescendentemente" para ordenar el diccionario antes de
	 * cargar la informacion en los respectivos JLabel
	 */
	private void cargarJLabels() {
		// Se ordena primero el diccionario descendentemente, para que los items con
		// mayores puntos sean los primeros
		this.diccionarioPaisesPuntos = ordenarMapaDescendentemente(this.diccionarioPaisesPuntos);
		// Se cargan las claves ordenadas del diccionario que son los nombres de los
		// paises en una lista
		List<String> listaClaves = new ArrayList<>(this.diccionarioPaisesPuntos.keySet());
		// Se cargan los valores ordenados del diccionario que son los puntos de cada
		// pais en una lista
		List<Integer> listaValores = new ArrayList<>(this.diccionarioPaisesPuntos.values());
		// Se recorre el JPanel "panelPaisesPuntos" para acceder a los JLabel que
		// contiene y manipularlos
		for (int i = 0; i < vista.panelPaisesPuntos.getComponentCount(); i++) {
			// Con la clase "Component" cogemos el componente del JPanel asociado al indice
			// (de 0, de 1, de 2..)
			Component componente = vista.panelPaisesPuntos.getComponent(i);
			// Si el componente es un JLabel, entra. En este caso solo hay JLabels en el
			// JPanel, con lo que siempre entra
			if (componente instanceof JLabel) {
				// Creamos un JLabel que sera el mismo que el componente actual de la iteracion
				JLabel label = (JLabel) componente;
				/*
				 * Manipulamos el JLabel anadiendole la informacion que nos interesa. En este
				 * caso el nombre del pais que se encuentra en la lista de claves ordenada y los
				 * puntos que se encuentran en la lista de valores ordenados
				 */
				
				label.setText(listaClaves.get(i) + " " + listaValores.get(i));
				
				//label.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/barras/ejemploLabel.png"));
				
				
			}
		}
		// Iteramos sobre el JPanel "panelBanderas" para asignar las banderas a su
		// correspondiente pais
		for (int i = 0; i < vista.panelBanderas.getComponentCount(); i++) {
			Component componente = vista.panelBanderas.getComponent(i);
			if (componente instanceof JLabel) {
				String nombrePais = listaClaves.get(i);
				//mostrarImagenPorPais(nombrePais);
				String nombreImagen = nombrePais.replace(" ", "") + ".png";
				JLabel label = (JLabel) componente;

				// Cargar la imagen
				ImageIcon icono = new ImageIcon(System.getProperty("user.dir") + "/resources/banderas/" + nombreImagen);
				//Image imagen = icono.getImage();

				// Obtener las dimensiones del JLabel
				//int anchoLabel = label.getWidth();
				//int altoLabel = label.getHeight();

				// Redimensionar la imagen al tamaño del JLabel
				//Image imagenRedimensionada = imagen.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);

				// Asignar la imagen redimensionada al JLabel
				label.setIcon(icono);
			}
		}
	}

	/**
	 * Funcionalidad que ordena descendentemente un diccionario pasado como
	 * parametro en vase al valor de la clave
	 * 
	 * @param mapa
	 * @return mapaOrdenado
	 */
	public static Map<String, Integer> ordenarMapaDescendentemente(Map<String, Integer> mapa) {
		// Cargamos el conjunto de cada clave valor en una lista para manipularlos
		List<Map.Entry<String, Integer>> listaDeEntradas = new ArrayList<>(mapa.entrySet());
		// Collections crea un comparador de valores, los cuales ordena con sort
		Collections.sort(listaDeEntradas, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
		// Creamos el mapa que almacenara las entradas ya ordenadas
		Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
		// Recorremos la lista de entradas ordenadas para ir anadiendolas en el
		// diccionario que acabamos de crear
		for (Map.Entry<String, Integer> entrada : listaDeEntradas) {
			mapaOrdenado.put(entrada.getKey(), entrada.getValue());
		}
		// Devolvemos el mapa ya ordenado descendentemente
		return mapaOrdenado;
	}

	/**
	 * Funcionalidad que accede a la lista "listaResultadosFaseNacional" para
	 * obtener los puntos desgnidos a cada cantante, busca el pais al que pertenece
	 * dicho cantante con el metodo "getCantante" de la clase "gBD" y actualiza el
	 * el diccionario con el metodo "actualizarDiccionario" con los puntos
	 * designados. Hara un insert en la tabla "RESULTADOS_EUROVISION" en caso de que
	 * ya no queden mas paises por votar
	 * 
	 * @param tamanio
	 */
	private void mostrarSiguienteResultado(int tamanio) {
		// Se borra el texto asociado al textArea "textAreaPrueba" con cada clic
		vista.textAreaPrueba.setText("");
		// Si el tamanio pasado como parametro es mayor o igual al indice atributo de
		// instancia, entra
		if (this.indiceListaResultadosNacionales <= tamanio) {
			// Accedemos a la informacion del pais que vota y a que cantantes vota. Usamos
			// el indice atributo de instancia
			String nombrePais = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getPais();
			String cantantePrimero = listaResultadosFaseNacional.get(indiceListaResultadosNacionales)
					.getCantantePrimero();
			String cantanteSegundo = listaResultadosFaseNacional.get(indiceListaResultadosNacionales)
					.getCantanteSegundo();
			String cantanteTercero = listaResultadosFaseNacional.get(indiceListaResultadosNacionales)
					.getCantanteTercero();

			// Vamos concatenando la informacion segun la queramos mostrar en el textArea
			// "textAreaPrueba"
			String info = "PAIS VOTANTE: " + nombrePais + "\n";

			// Sabiendo el nombre del cantante, usamos el metodo "getCantante" de la clase
			// "gBD" para obtener su pais
			String paisCantante1 = gBD.getPaisCantante(cantantePrimero);
			String paisCantante2 = gBD.getPaisCantante(cantanteSegundo);
			String paisCantante3 = gBD.getPaisCantante(cantanteTercero);

			// Concatenamos de nuevo para ir dejando trazas de la informacion que vamos
			// obteneniendo y la anadimos al textArea
			info += "\tVota como primer cantante con 15 points a " + cantantePrimero + " (" + paisCantante1 + ")\n";
			info += "\tVota como segundo cantante con 10 points a " + cantanteSegundo + " (" + paisCantante2 + ")\n";
			info += "\tVota como tercer cantante con 8 points a " + cantanteTercero + " (" + paisCantante3 + ")\n";
			vista.textAreaPrueba.setText(info);

			// Se hace uso del metodo "actualizarDiccionario" para ir sumando los puntos
			// asociados a cada pais
			actualizarDiccionario(paisCantante1, 15);
			actualizarDiccionario(paisCantante2, 10);
			actualizarDiccionario(paisCantante3, 8);

			// Con cada clic se carga la informacion del diccionario atributo de instancia
			// en los JLabels
			cargarJLabels();

			// IMPORTANTE IMPORTANTISIMO IMPORTANTERRIMO incrementar el indice que en cada
			// clic para acceder al siguiente item
			this.indiceListaResultadosNacionales++;

			// Si el indice sigue siendo menor o igual al tamanio pasado como parametro
			// entra
			if (indiceListaResultadosNacionales <= tamanio) {
				// En cada clic mostramos el siguiente nombre del pais que vota en el JButton
				// "btnRefrescarInfo"
				vista.btnRefrescarInfo
						.setText(listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getPais());
				// Si el indice ya no es menor o igual al tamanio pasado como parametro entra
				String nombrePais1=listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getPais();
				nombrePais1=nombrePais1.replace(" ", "");
				vista.lblImagenPresentador.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/votaciones/"+nombrePais1+".jpg"));
			} else {
				// Cambiamos el texto del JButton "btnRefrescarInfo" para saber que el siguiente
				// clic cambiara el JPanel
				vista.btnRefrescarInfo.setText("ACTUACION GANADORA");
				// Se realiza un insert en la tabla "RESULTADOS_EUROVISION" al terminar las
				// votaciones
				guardarResultadosEurovision();
			}
			// Si el indice ya no es menor o igual al tamanio pasado como parametro lo
			// mostramos en el textArea como traza
		} else {
			vista.textAreaPrueba.setText("Fin votaciones");
		}
	}

	/**
	 * Funcionalidad que recorre el diccionario atributo de instancia
	 * "diccionarioPaisesPuntos" para crear un objeto de la clase
	 * "ResultadosEurovision", el cual sera insertado en la tabla
	 * "RESULTADOS_EUROVISION"
	 */
	public void guardarResultadosEurovision() {
		// Creamos el objeto en el que guardaremos la informacion
		ResultadosEurovision resultado = new ResultadosEurovision();
		// Creamos un booleano que nos controle la primera iteracion sobre el
		// diccionario para obtener el ganador
		boolean primeraIteracion = true;
		// Variable donde guardaremos el ganador
		String ganador = null;
		// Recorremos las claves del diccionario
		for (String clavePais : this.diccionarioPaisesPuntos.keySet()) {
			// Obtenemos los puntos asociados al pais en el diccionario
			int valorPuntos = this.diccionarioPaisesPuntos.get(clavePais);
			// Si es la primera iteracion, entra
			if (primeraIteracion == true) {
				// Setteamos el pais ganador de Eurovision en el objeto "resultado" y de paso
				// nos lo guardamos
				ganador = clavePais;
				this.paisGanador = ganador;
				primeraIteracion = false;
				resultado.setPaisGanador(ganador);
			}
			// Si el pais coincide con su respectivo nombre se hara un set de ese pais
			// anadiendole los puntos de la gala
			if (clavePais.equals("Espania")) {
				resultado.setAlemania(valorPuntos);
			} else if (clavePais.equals("Alemania")) {
				resultado.setAlemania(valorPuntos);
			} else if (clavePais.equals("Francia")) {
				resultado.setFrancia(valorPuntos);
			} else if (clavePais.equals("Italia")) {
				resultado.setItalia(valorPuntos);
			} else if (clavePais.equals("Portugal")) {
				resultado.setPortugal(valorPuntos);
			} else if (clavePais.equals("Reino Unido")) {
				resultado.setReinoUnido(valorPuntos);
			} else if (clavePais.equals("Polonia")) {
				resultado.setPolonia(valorPuntos);
			} else if (clavePais.equals("Paises Bajos")) {
				resultado.setPaisesBajos(valorPuntos);
			} else if (clavePais.equals("Rumania")) {
				resultado.setRumania(valorPuntos);
			} else if (clavePais.equals("Grecia")) {
				resultado.setGrecia(valorPuntos);
			}
		}
		// Creamos la fecha actual para settearla en el objeto "resultado"
		Date fechaActual = Calendar.getInstance().getTime();
		resultado.setFechaGala(fechaActual);
		// Insertamos el objeto resultado haciendo uso del metodo
		// "insertResultadoEurovision" de la clase "gestionDeDatos"
		gBD.insertResultadosEurovision(resultado);
		// Traza
		System.out.println("DATOS GUARDADOS EN TABLA EUROVISION");
	}

	/**
	 * Funcionalidad que cambia la visibilidad de los distintos JPanels para mostrar
	 * el JPanel "panelAutoria"
	 */
	public void getPerspectivaAutoria() {
		vista.panelInicial.setVisible(false);
		vista.panelVotacionesNacionales.setVisible(false);
		vista.panelVotaciones.setVisible(false);
		if (this.panel4_activo == true) {
			vista.lblActuacionGanador.setVisible(false);
		}
		vista.panelAutoria.setVisible(true);
	}

	/**
	 * Funcionalidad que mostrara el gif de la actuacion del ganador de Eurovision
	 * en el JLabel "lblActuacionGanador"
	 * 
	 * @param nombrePais
	 */
	public void mostrarGifGanadorFinal(String nombrePais) {
		// Le quitamos los espacios al pais ganador para llamar al gif correspondiente
		String nombreGif = nombrePais.replaceAll(" ", "");
		// Anadimos el formato .gif al string para usarlo en la ruta
		nombreGif += ".gif";
		// Asignamos un Icon al JLabel "lblActuacionGanador", especificando la ruta y
		// concatenando el nombre del gif asociado
		vista.lblActuacionGanador
				.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/" + nombreGif));
	}

	/**
	 * Funcionalidad que ofrece la imagen correspondiente al ganador de la ejecucion
	 * anterior haciendo uso del metodo "getPaisGanador" de la clase
	 * "GestionDeDatos". En caso de no haber, asignara una imagen por defecto
	 */
	public void mostrarImagenGanadorAnterior() {
		// Pintar logo del pais ganador de la anterior gala
		String ganador = gBD.getPaisGanador();
		if (ganador == null) {
			// Si la tabla de ganador esta vacia ponemos una imagen por defecto
			ganador = "Eurovision";
		}
		vista.lblLogoInicio
				.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/logos/logo_" + ganador + ".png"));

	}

	/**
	 * Funcionalidad que inicializa el Timer "timerCronometro", el cual controlara
	 * el tiempo que es visible el archivo .gif asociado al JLabel "lblLogoInicio"
	 */
	private static void iniciarCronometroTransicion() {
		reproducirSonido(System.getProperty("user.dir") + "/resources/introEuroSonido.wav");
		// Se inicializa la instancia y se especifica que se dispare cada segundo (1000
		// milisegundos) y anade un escuchador
		timerCronometro = new Timer(2440, new ActionListener() {
			// En el actionPerformed redefinido se controlara el atributo de instancia
			// "tiempoTransicion" y su valor
			@Override
			public void actionPerformed(ActionEvent e) {
				// Si el valor de "tiempoTransicion" es mayor que 0 le resta 1
				if (tiempoTransicion > 0) {
					tiempoTransicion = tiempoTransicion - 1;
					// Si el valor de "tiempoTransicion" es igual a 0 entra
				} else if (tiempoTransicion == 0) {
					// Ocultamos el JLabel "lblLogoInicio" y los JPanel "panelInicial" y
					// "panelVotacionesNacionales"
					vista.getLblLogoInicio().setVisible(false);
					vista.getPanelInicial().setVisible(false);
					vista.getPanelVotacionesNacionales().setVisible(true);
					// Paramos el Timer
					timerCronometro.stop();
					// Volvemos a mostrar el JMenuBar cuando acaba el gif de transicion
					vista.menuBar.setVisible(true);
					reproducirSonido(System.getProperty("user.dir") + "/resources/taylor/Welcome_join.wav");

					// Volvemos a darle el valor original de tiempo a "tiempoTransicion" aunque no
					// hace falta porque no se usara mas
					tiempoTransicion = 2;
				}
			}
		});
		// Al llamar al metodo se inicia el Timer
		timerCronometro.start();
		// Se ocula el JMenuBar "menuBar" mientras el Timer este activo para controlar
		// errores de perspectiva
		vista.menuBar.setVisible(false);
	}

	/**
	 * Funcionalidad que ofrece la interfaz grafica de usuario. Es llamado desde el
	 * main con una instancia Controlador
	 */
	private static void reproducirSonido(String rutaAudio) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(rutaAudio).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void iniciarVista() {
		Controlador.vista.setVisible(true);
	}
}
