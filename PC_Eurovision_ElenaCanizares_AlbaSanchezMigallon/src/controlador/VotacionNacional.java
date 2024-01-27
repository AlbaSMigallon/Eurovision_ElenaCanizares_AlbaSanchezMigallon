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

	public VotacionNacional() {
		this.resultadosNacionales= new ArrayList<ResultadosFaseNacional>();

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
	
	public List<PorcentajesRangoedad> getPorcentajes(SessionFactory sessionFactory) {// mover a gestiondedatos
		Session session = null;
		List<PorcentajesRangoedad> paises = null;

		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			Query query = sessionFactory.getCurrentSession().createQuery("FROM PORCENTAJES_RANGOEDAD");
			paises = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (null != session) {
				session.getTransaction().rollback();
			}
			throw e;
		} finally {
			if (null != session) {
				session.close();
			}
		}

		return paises;
	}

	
	public void run() {
		/////////////////////////////////////////////
		SessionFactory sessionFactory = null;
		ResultadosFaseNacional resultadoFaseNacional = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();

			List<PorcentajesRangoedad> porcentajes = getPorcentajes(sessionFactory);

			for (int i = 0; i < porcentajes.size(); i++) {
				resultadoFaseNacional=generarClientes(porcentajes.get(i));
				this.resultadosNacionales.add(resultadoFaseNacional);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}


}
