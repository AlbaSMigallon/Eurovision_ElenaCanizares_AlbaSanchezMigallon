package controlador;

import java.util.ArrayList;
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

	Vista vista;

	public VotacionNacional(Vista vista) {

		this.vista = vista;

	}



	public void run() {

		// ResultadosFaseNacional resultadoFaseNacional = null;
		try {
			boolean salir = false;

			GestionDeDatos gBD = GestionDeDatos.getInstance();
			List<ClientePais> clientesPais = new ArrayList<>();
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
				clientesPais.add(clientePais);
				clientePais.start();
			}




			/*
			 * Aqui lo que hacemos es habilitar el boton de pasar a la fase de votacion
			 * eurovision cuando todo el proceso de votacion nacional acabe. De esta manera
			 * controlamos que se empiece laa fase de suma de votos finales sin que termine
			 * la votacion nacional
			 */

			/*
			 * En cliente tenemos un boolean que se pone a true cuando obtiene respuesta el
			 * cliente de fin de insert del registro en el hiloeurovision. Lo que hacemos en
			 * este bucle es recorrer la lista de clientes hasta que tengamos todos esos
			 * boolean a true. Eso quiere decir que los insert estan todos acabados y
			 * podemos habilitar el boton para pasar a la siguiente fase sin que nos de
			 * error y salir del bucle.
			 */
			while (!salir) {
				int contador = 0;
				for (int i = 0; i < clientesPais.size(); i++) {
					if (clientesPais.get(i).isEsFinCliente()) {
						contador++;
					}
				}

				if (contador == clientesPais.size()) {
					// Si se cambia el texto del boton, ha de cambiarse tambien el control que se hace de el en el Controlador
					vista.btnComenzarVotaciones.setText("COMENZAR VOTACIONES");
					vista.btnComenzarVotaciones.setEnabled(true);
					salir = true;
					System.out.println("BOOOOOTONNNN");
				}

			}



		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}
	}

}
