package controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import persistencias.PorcentajesRangoedad;
import persistencias.ResultadosFaseNacional;

public class VotacionNacional extends Thread {
	/*
	 * Este hilo lo creamos para gestionar todas la fase de votaciones nacionales.
	 * Hacemos esto para controlar que cuando acabe este proceso, cuando el hilo no
	 * este vivo, hagamos el insert en la BBDD y tambien podamos pasar a la pantalla
	 * de resultados, sabiendo que ya tenemos todo el proceso finalizado
	 */
	
	List<ResultadosFaseNacional> resultadosNacionales;
	GestionDeDatos gBD;
	

	public VotacionNacional(GestionDeDatos gBD) {
		this.resultadosNacionales= new ArrayList<ResultadosFaseNacional>();
		this.gBD= gBD;

	}

	
	
	public ResultadosFaseNacional generarClientes(PorcentajesRangoedad porcentajes) {
		ResultadosFaseNacional resultadoFaseNacional = null;
		try {
			ClientePais cliente = new ClientePais(porcentajes);
			resultadoFaseNacional= new ResultadosFaseNacional();
			resultadoFaseNacional=cliente.iniciarCliente();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultadoFaseNacional;

	}
	
	

	
	public void run() {

		ResultadosFaseNacional resultadoFaseNacional = null;
		try {

			List<PorcentajesRangoedad> porcentajes = gBD.getPorcentajes();

			for (int i = 0; i < porcentajes.size(); i++) {
				System.out.println("Enviamos las votaciones de "+porcentajes.get(i).getNombrePais());
				resultadoFaseNacional=generarClientes(porcentajes.get(i));
				this.resultadosNacionales.add(resultadoFaseNacional);
				//InserT de resultados por pais-cliente en tabla
				this.gBD.insertResultadosFaseNacional(resultadoFaseNacional);
				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}


}
