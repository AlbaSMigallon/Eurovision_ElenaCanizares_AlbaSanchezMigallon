package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import vista.Vista;

public class Controlador implements ActionListener {
	public Vista vista;
	public VotacionNacional votacionNacional;
	public GestionDeDatos gBD;

	public Controlador(Vista frame) {
		// TODO Auto-generated constructor stub
		this.vista = frame;
		this.vista.btnComenzarInicio.addActionListener(this);
		//this.vista.btnComenzarVotaciones.addActionListener(this);

		iniciarAplicacion();
	}

	public void iniciarAplicacion() {
		/*
		 * Metodo para iniciar nuestra aplicacion. Consulta de ultimo ganador, pintar el
		 * logo segun consulta, delete en tabla, lanzar hilo votaciones, habilitar boton
		 * de fase Eurovision al acabar el hilo
		 */
		// TODO Auto-generated method stub
		try {

			/*
			 * Pintar logo del pais ganador de la anterior gala. La gala de eurovision se
			 * celebra en el pais ganador del anio anterior y en logo ponen la bandera del
			 * pais. Nosotros simularemos lo mismo
			 * 
			 */
			this.gBD = new GestionDeDatos();
			String ganador=this.gBD.getPaisGanador();
			if (ganador == null) {
				// la tabla esta vacia, cambiamos el String para que al concatenar la ruta para
				// pintar el logo tire del generico
				ganador = "Eurovision";

			}		
			vista.lblLogoInicio.setIcon(new ImageIcon(
					"C:\\\\Users\\\\Alba\\\\git\\\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\\\resources\\logos\\logo_"+ganador+".png"));
			/*
			 * Delete en la tabla RESULTADOS_FASE_NACIONAL
			 */
			
			this.gBD.deleteResultadosFaseNacional();// vaciamos de registros la tabla de RESULTADOS_FASE_NACIONAL

			/*
			 * Inicio del hilo de votacion nacional
			 */
			votacionNacional = new VotacionNacional(this.gBD);
			votacionNacional.start();
			votacionNacional.join();
			/*
			 * Habilitar el boton para pasar a votaciones Eurovision cuando acabe el proceso
			 * de votacion nacional
			 */
			if (!votacionNacional.isAlive()) {
				//vista.btnComenzarVotaciones.setEnabled(true);
			}

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.btnComenzarInicio) {
			// pasamos a pantalla de votacion nacional
			vista.panelInicial.setVisible(false);
			//vista.panelVotacionesNacionales.setVisible(true);

		}

		if (e.getSource() == vista.btnComenzarVotaciones) {
			// iniciamos proceso de votacion en eurovision.
			vista.panelVotacionesNacionales.setVisible(false);
			vista.panelVotacionesEurovision.setVisible(true);

		}

	}

}
