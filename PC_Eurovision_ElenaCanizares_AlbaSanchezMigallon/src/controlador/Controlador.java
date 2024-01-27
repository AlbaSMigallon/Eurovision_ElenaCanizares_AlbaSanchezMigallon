package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista;

public class Controlador implements ActionListener {
	public Vista vista;
	public VotacionNacional votacionNacional;

	public Controlador(Vista frame) {
		// TODO Auto-generated constructor stub
		this.vista = vista;
		// this.vista.btnComenzarInicio.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			/*
			 * Desde el inicio de la aplicacion comenzamos a trabjar con la generacion de
			 * las votaciones nacionales pero, solo cuando pasemos a demos al boton de pasar
			 * a la fase de votacion en eurovision, se ejecutará el insert de los resultados
			 * en la BBDD. De esta manera evitaremos que si no se continua el proceso se nos
			 * quede una de nuestras tablas a completar y otra no. Ese boton solo estará
			 * disponible cuando acabe toda votacion nacional, de esta forma nos aseguramos
			 * un correcto insert
			 */
			/////////// consulta para el logo
			votacionNacional.start();
			votacionNacional.join();
			// habilitamso poder pasar a la fase eurovision tras terminar toda la parte
			// nacional
			vista.btnComenzarVotaciones.setEnabled(true);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (e.getSource() == vista.btnComenzarInicio) {
			// iniciamos proceso de votacion nacional
			vista.panelInicial.setVisible(false);
			vista.panelVotacionesNacionales.setVisible(true);

		}

		if (e.getSource() == vista.btnComenzarVotaciones) {
			// iniciamos proceso de votacion en eurovision. Ejecutamos el insert en nacional
			// insert en ResultadosFaseNacional
			vista.panelVotacionesNacionales.setVisible(false);
			vista.panelVotacionesEurovision.setVisible(true);

		}

	}

}
