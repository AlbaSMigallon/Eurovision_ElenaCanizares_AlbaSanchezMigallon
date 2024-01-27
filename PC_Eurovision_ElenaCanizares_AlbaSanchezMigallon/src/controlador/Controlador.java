package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista;

public class Controlador implements ActionListener {
	public Vista vista;
	public VotacionNacional votacionNacional;
	public GestionDeDatos gBD;

	public Controlador(Vista frame) {
		// TODO Auto-generated constructor stub
		this.vista = vista;
		// this.vista.btnComenzarInicio.addActionListener(this);
		this.gBD= new GestionDeDatos();
		iniciarVotaciones();
	}

	public void iniciarVotaciones() {
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
			
			/*
			 *  Pintar logo del pais ganador de la anterior gala. La gala de eurovision se
			 *  celebra en el pais ganador del anio anterior y en logo ponen la bandera del
			 *  pais. Nosotros simularemos lo mismo
			 */
			
			/*
			 * Delete en la tabla RESULTADOS_FASE_NACIONAL 
			 */
			
			votacionNacional = new VotacionNacional(this.gBD);
		
			votacionNacional.start();
			votacionNacional.join();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

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
