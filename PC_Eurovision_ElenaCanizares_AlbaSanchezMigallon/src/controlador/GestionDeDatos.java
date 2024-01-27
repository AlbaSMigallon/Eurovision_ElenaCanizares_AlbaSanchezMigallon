package controlador;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import persistencias.PorcentajesRangoedad;
import persistencias.ResultadosFaseNacional;

public class GestionDeDatos {
	/*
	 * Clase utilizada para gestionar datos
	 */
	
	public List<PorcentajesRangoedad> getPorcentajes(SessionFactory sessionFactory) {
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

	
	public void getPorcentajesRangoedad() {
		SessionFactory sessionFactory = null;
		ResultadosFaseNacional resultadoFaseNacional = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();

			List<PorcentajesRangoedad> porcentajes = getPorcentajes(sessionFactory);

			
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
