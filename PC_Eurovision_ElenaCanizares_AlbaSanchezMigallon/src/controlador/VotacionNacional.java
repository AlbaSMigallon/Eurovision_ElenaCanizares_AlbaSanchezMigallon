package controlador;

import java.util.List;
import persistencias.Cantantes;
import persistencias.PorcentajesRangoedad;
import vista.Vista;

/**
 * Este hilo lo creamos para gestionar todas la fase de votaciones nacionales. Hacemos esto para controlar que cuando
 * acabe este proceso, cuando el hilo no este vivo, hagamos el insert en la BBDD y tambien podamos pasar a la pantalla
 * de resultados, sabiendo que ya tenemos todo el proceso finalizado
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 * @see Thread
 */
public class VotacionNacional extends Thread {

	//GestionDeDatos gBD;
	Vista vista;

	public VotacionNacional(Vista vista) {
		//this.gBD = gBD;
		this.vista = vista;

	}

/*
	public ResultadosFaseNacional generarClientes(PorcentajesRangoedad porcentajes) {
		/*
		 * Crea los clientes, uno por pais y le pasa los datos de los porcentajes por
		 * rango de edad

		ResultadosFaseNacional resultadoFaseNacional = null;
		try {
			ClientePais cliente = new ClientePais(porcentajes);
			resultadoFaseNacional = new ResultadosFaseNacional();
			resultadoFaseNacional = cliente.iniciarCliente();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultadoFaseNacional;

	}
*/

	public void run() {

		// ResultadosFaseNacional resultadoFaseNacional = null;
		try {

			GestionDeDatos gBD= GestionDeDatos.getInstance();

			List<PorcentajesRangoedad> porcentajes = gBD.getPorcentajes();
			List<Cantantes> cantantes = gBD.getCantantes();

			/*
			 * Recorremos la lista de porcentajes, que tiene la lista de cada pais y su
			 * rango de edad. por cada pais nor creamos el cliente del pais y le pasamos el
			 * objeto de porcentajes para que el cliente pueda luego tratarlos y crear una
			 * peticion por cada votante segun rango
			 */
			for (int i = 0; i < porcentajes.size(); i++) {
				System.out.println("Enviamos las votaciones de " + porcentajes.get(i).getNombrePais());
				ClientePais clientePais = new ClientePais(porcentajes.get(i), cantantes);
				clientePais.start();
				//resultadoFaseNacional = generarClientes(porcentajes.get(i));
				// this.resultadosNacionales.add(resultadoFaseNacional);
				/*
				 * AQUI YA TENEMOS LOS RESULTADOS POR PAIS. Ya se hizo todo el proceso de
				 * cliente servidor
				 */

				//this.gBD.insertResultadosFaseNacional(resultadoFaseNacional);// InserT de resultados por pais-cliente en
																				// tabla

			}
			/*
			 * Aqui lo que hacemos es habilitar el voton de pasar a la fase de votacion eurovision cuando todo el proceso de votacion nacional acabe.
			 * De esta manera controlamos que se empiece laa fase de suma de votos finales sin que termine la votacion nacional
			 */
			/*vista.btnComenzarVotaciones.setText("COMENZAR");
			vista.btnComenzarVotaciones.setEnabled(true);*/

		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}
	}

}
