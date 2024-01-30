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
	private GestionDeDatos gBD;
	private static int tiempoTransicion;
	private static int tiempoEurovision;
	private static Timer timerCronometro;
	private static Timer timerVotaciones;

	public Controlador() {
		Controlador.vista = new Vista();
		this.votacionNacional = new VotacionNacional(vista);
		this.gBD= GestionDeDatos.getInstance();
		Controlador.tiempoTransicion = 2;
		Controlador.tiempoEurovision = 21;

		// Asignamos escuchadores a los JButton
		Controlador.vista.btnComenzarInicio.addActionListener(this);
		Controlador.vista.btnComenzarVotaciones.addActionListener(this);
		Controlador.vista.btnRefrescarInfo.addActionListener(this);

		// Vaciamos de registros la tabla de RESULTADOS_FASE_NACIONAL
		gBD.deleteResultadosFaseNacional();
		mostrarImagenGanadorAnterior();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnComenzarInicio) {
			vista.btnComenzarInicio.setVisible(false);
			vista.lblLogoInicio.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/gifTransicion.gif"));
			// Iniciamos la votacion nacional desde que se hace clic en el JButton "btnComenzarInicio"
			votacionNacional.start();
			iniciarCronometroTransicion();
			iniciarCronometroVotacionesEurovision();

		}else if (e.getSource() == vista.btnComenzarVotaciones) {
			timerCronometro.stop();
			vista.panelVotacionesNacionales.setVisible(false);
			vista.panelVotaciones.setVisible(true);
		}else if(e.getSource() == vista.btnRefrescarInfo) {
			List<ResultadosFaseNacional> lista= new ArrayList<>();
			lista = gBD.getResultadosFaseNacional();
			for(ResultadosFaseNacional r: lista) {
				System.out.println(r.getPais()+"\n");
				System.out.println(r.getCantantePrimero());
				System.out.println(r.getCantanteSegundo());
				System.out.println(r.getCantanteTercero());
			}
		}
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
                	tiempoTransicion = 2;
                }
            }
        });
		timerCronometro.start();
    }

	private static void iniciarCronometroVotacionesEurovision() {
		timerVotaciones = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tiempoEurovision > 0) {
             	   tiempoEurovision = tiempoEurovision - 1;
                }else if(tiempoEurovision == 0) {
                	vista.getBtnComenzarVotaciones().setText("COMENZAR");
                	vista.getBtnComenzarVotaciones().setEnabled(true);
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
