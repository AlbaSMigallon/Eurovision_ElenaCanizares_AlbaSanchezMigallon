package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import persistencias.Cantantes;
import persistencias.ResultadosFaseNacional;
import vista.Vista;

public class Controlador implements ActionListener {
	private static Vista vista;
	private VotacionNacional votacionNacional;
	private static GestionDeDatos gBD;
	private static int tiempoTransicion;
	private static int tiempoEurovision;
	private static Timer timerCronometro;
	private static Timer timerVotaciones;
	private static List<ResultadosFaseNacional> listaResultadosFaseNacional;
	private Map<String, Integer> diccionarioPaisesPuntos;
	private int indiceListaResultadosNacionales;
	private boolean panel1_activo;
	private boolean panel2_activo;
	private boolean panel3_activo;

	public Controlador() {
		Controlador.vista = new Vista();
		Controlador.listaResultadosFaseNacional = new ArrayList<>();
		Controlador.gBD= GestionDeDatos.getInstance();
		Controlador.listaResultadosFaseNacional = new ArrayList<>();
		Controlador.tiempoTransicion = 2;
		Controlador.tiempoEurovision = 21;
		this.votacionNacional = new VotacionNacional(vista);
		this.diccionarioPaisesPuntos = new HashMap<>();
		this.panel1_activo = true;
		this.panel2_activo = false;
		this.panel3_activo = false;
		this.indiceListaResultadosNacionales = 0;

		// Asignamos escuchadores a los JButton
		Controlador.vista.btnComenzarInicio.addActionListener(this);
		Controlador.vista.btnComenzarVotaciones.addActionListener(this);
		Controlador.vista.btnRefrescarInfo.addActionListener(this);
		Controlador.vista.btnVolver.addActionListener(this);

		// Asignamos escuchador al JMenuItem
		vista.itemMenuInformacion.addActionListener(this);

		// Vaciamos de registros la tabla de RESULTADOS_FASE_NACIONAL
		gBD.deleteResultadosFaseNacional();

		// Mostramos la imagen del ganador anterior en el JPanel inicial
		mostrarImagenGanadorAnterior();

		// Iniciamos la votacion nacional desde que se hace clic en el JButton "btnComenzarInicio"
		votacionNacional.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnComenzarInicio) {
			vista.btnComenzarInicio.setVisible(false);
			this.panel1_activo = false;
			this.panel2_activo = true;
			this.panel3_activo = false;
			vista.lblLogoInicio.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/gifTransicion.gif"));

			// Se inicia el cronometro que controla el gif de transicion entre el primer JPanel y el segundo
			iniciarCronometroTransicion();

			// Se inicia el cronometro que controla la espera hasta la disponibilidad del JButon "btnComenzarVotaciones"
			iniciarCronometroVotacionesEurovision();
		}else if (e.getSource() == vista.btnComenzarVotaciones) {
			this.panel1_activo = false;
			this.panel2_activo = false;
			this.panel3_activo = true;
			vista.panelVotacionesNacionales.setVisible(false);
			vista.panelVotaciones.setVisible(true);
			vista.btnRefrescarInfo.setText("Comenzar");
		}else if (e.getSource() == vista.btnRefrescarInfo) {
			if(vista.btnRefrescarInfo.getText().equals("Comenzar")) {
				vista.btnRefrescarInfo.setText(listaResultadosFaseNacional.get(0).getPais());
				cargarDiccionario();
				cargarJLabels();
			}else {
				int tamanio = listaResultadosFaseNacional.size() - 1;
				mostrarSiguienteResultado(tamanio);
			}
			/*if(this.indiceListaResultadosNacionales == 0) {
				cargarDiccionario();
				cargarJLabels();
			}
			int tamanio = listaResultadosFaseNacional.size() - 1;
			mostrarSiguienteResultado(tamanio);*/

		}else if (e.getSource() == vista.itemMenuInformacion) {
			getPerspectivaAutoria();
		}else if(e.getSource() == vista.btnVolver) {
			if(this.panel1_activo == true) {
				vista.panelAutoria.setVisible(false);
				vista.panelInicial.setVisible(true);
			}else if(this.panel2_activo == true){
				vista.panelAutoria.setVisible(false);
				vista.panelVotacionesNacionales.setVisible(true);
			}else if(this.panel3_activo == true) {
				vista.panelAutoria.setVisible(false);
				vista.panelVotaciones.setVisible(true);
			}
		}
	}

	private void cargarDiccionario() {
		for(ResultadosFaseNacional r: Controlador.listaResultadosFaseNacional) {
			this.diccionarioPaisesPuntos.put(r.getPais(), 0);
		}
	}

	private void actualizarDiccionario(String nombrePais, int puntos) {
		for (String clavePais : this.diccionarioPaisesPuntos.keySet()) {
            int valorPuntos = this.diccionarioPaisesPuntos.get(clavePais);
            if(clavePais.equals(nombrePais)) {
            	this.diccionarioPaisesPuntos.put(clavePais, valorPuntos + puntos);
            	System.out.println("Clave: " + clavePais + ", Valor: " + valorPuntos);
            }
        }
	}

	private void cargarJLabels() {
		this.diccionarioPaisesPuntos = ordenarMapaDescendentemente(this.diccionarioPaisesPuntos);
		List<String> listaClaves = new ArrayList<>(this.diccionarioPaisesPuntos.keySet());
		List<Integer> listaValores = new ArrayList<>(this.diccionarioPaisesPuntos.values());
    	for (int i = 0; i < vista.panelPaisesPuntos.getComponentCount(); i++) {
		    Component componente = vista.panelPaisesPuntos.getComponent(i);
		    if (componente instanceof JLabel) {
		    	JLabel label = (JLabel) componente;
		    	label.setText(listaClaves.get(i) + " " + listaValores.get(i));
		    }
		}
	}

	public static Map<String, Integer> ordenarMapaDescendentemente(Map<String, Integer> mapa) {
        List<Map.Entry<String, Integer>> listaDeEntradas = new ArrayList<>(mapa.entrySet());
        Collections.sort(listaDeEntradas, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entrada : listaDeEntradas) {
            mapaOrdenado.put(entrada.getKey(), entrada.getValue());
        }
        return mapaOrdenado;
    }

	private void mostrarSiguienteResultado(int tamanio) {
        vista.textAreaPrueba.setText("");
        if (this.indiceListaResultadosNacionales <= tamanio) {
            String nombrePais = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getPais();
            String cantantePrimero = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getCantantePrimero();
            String cantanteSegundo = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getCantanteSegundo();
            String cantanteTercero = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getCantanteTercero();
            String info = "PAIS VOTANTE: " + nombrePais + "\n";
            String paisCantante1 = gBD.getCantante(cantantePrimero);
            String paisCantante2 = gBD.getCantante(cantanteSegundo);
            String paisCantante3 = gBD.getCantante(cantanteTercero);
            info += "\tVota como primer cantante con 15 points a " + cantantePrimero + " (" + paisCantante1 + ")\n";
            info += "\tVota como segundo cantante con 10 points a " + cantanteSegundo + " (" + paisCantante2 + ")\n";
            info += "\tVota como tercer cantante con 8 points a " + cantanteTercero + " (" + paisCantante3 + ")\n";
            vista.textAreaPrueba.setText(info);
            actualizarDiccionario(paisCantante1,  15);
            actualizarDiccionario(paisCantante2,  10);
            actualizarDiccionario(paisCantante3,  8);
            cargarJLabels();
            this.indiceListaResultadosNacionales++;
            if(indiceListaResultadosNacionales <= tamanio) {
            	vista.btnRefrescarInfo.setText(listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getPais());
            }else {
            	vista.btnRefrescarInfo.setText("Siguiente panel");
            }
        } else {
            vista.textAreaPrueba.setText("Fin votaciones");
            vista.btnRefrescarInfo.setText("FIN..POR AHORA");
        }
    }

	public void getPerspectivaAutoria() {
		vista.panelInicial.setVisible(false);
		vista.panelVotacionesNacionales.setVisible(false);
		vista.panelVotaciones.setVisible(false);
		vista.panelAutoria.setVisible(true);
	}

	public void mostrarImagenGanadorAnterior() {
		// Pintar logo del pais ganador de la anterior gala
		String ganador = gBD.getPaisGanador();
		if (ganador == null) {
			// Si la tabla de ganador esta vacia ponemos una imagen por defecto
			ganador = "Eurovision";
		}
		vista.lblLogoInicio.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/logos/logo_"+ganador+".png"));
	}

	private static void iniciarCronometroTransicion() {
		timerCronometro = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tiempoTransicion > 0) {
             	   tiempoTransicion = tiempoTransicion - 1;
                }else if(tiempoTransicion == 0) {
                	vista.getLblLogoInicio().setVisible(false);
                	vista.getPanelInicial().setVisible(false);
                	vista.getPanelVotacionesNacionales().setVisible(true);
                	timerCronometro.stop();
                	tiempoTransicion = 2;
                }
            }
        });
		timerCronometro.start();
		vista.menuBar.setVisible(false);
    }

	private static void iniciarCronometroVotacionesEurovision() {
		timerVotaciones = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tiempoEurovision > 0) {
             	   tiempoEurovision = tiempoEurovision - 1;
                }else if(tiempoEurovision == 0) {
                	vista.getBtnComenzarVotaciones().setEnabled(true);
                	vista.menuBar.setVisible(true);
                	vista.getBtnComenzarVotaciones().setText("COMENZAR");
                	listaResultadosFaseNacional = gBD.getResultadosFaseNacional();
                	timerVotaciones.stop();
                	tiempoEurovision = 21;
                }
            }
        });
		timerVotaciones.start();
    }

	public void iniciarVista() {
		Controlador.vista.setVisible(true);
	}
}
