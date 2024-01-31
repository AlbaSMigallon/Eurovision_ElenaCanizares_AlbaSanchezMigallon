package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

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
		}else if (e.getSource() == vista.btnRefrescarInfo) {
			int tamanio = listaResultadosFaseNacional.size() - 1;
			mostrarSiguienteResultado(tamanio);

			/*for(ResultadosFaseNacional r: listaResultadosFaseNacional) {
				System.out.println(r.getPais()+"\n");
				System.out.println(r.getCantantePrimero());
				System.out.println(r.getCantanteSegundo());
				System.out.println(r.getCantanteTercero());
			}*/
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

	private void mostrarSiguienteResultado(int tamanio) {
        vista.textAreaPrueba.setText("");
        if (this.indiceListaResultadosNacionales <= tamanio) {
            String nombrePais = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getPais();
            String cantantePrimero = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getCantantePrimero();
            String cantanteSegundo = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getCantanteSegundo();
            String cantanteTercero = listaResultadosFaseNacional.get(indiceListaResultadosNacionales).getCantanteTercero();
            String info = "PAIS: " + nombrePais + "\n";
            info += "\tVota como primer cantante a " + cantantePrimero + "\n";
            info += "\tVota como segundo cantante a " + cantanteSegundo + "\n";
            info += "\tVota como tercer cantante a " + cantanteTercero + "\n";
            vista.textAreaPrueba.setText(info);
            vista.btnRefrescarInfo.setText(nombrePais);
        } else {
            vista.textAreaPrueba.setText("Fin votaciones");
            vista.btnRefrescarInfo.setText("FIN..POR AHORA");
        }
        this.indiceListaResultadosNacionales++;
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
