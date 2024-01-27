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
	private SessionFactory sessionFactory;
	// trabajamos con el mismo session factory de la calse

	public GestionDeDatos() {
		super();
		this.sessionFactory = null;
		this.sessionFactory = inicializarPoolConexiones();
	}

	/*
	 * metodo para hacer el insert en la tabla de RESULTADOS_FASE_NACIONAL. un
	 * insert por cada pais
	 */
	public void insertResultadosFaseNacional(ResultadosFaseNacional resultado) {
		Session session = null;

		try {
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();

			session.save(resultado);

			session.getTransaction().commit();
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
	}

	/*
	 * metodo para sacar los registro de los rangos de edad para calcular las
	 * votaciones nacionales
	 */
	public List<PorcentajesRangoedad> getPorcentajes() {
		Session session = null;
		List<PorcentajesRangoedad> paises = null;

		try {
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();

			Query<PorcentajesRangoedad> query = this.sessionFactory.getCurrentSession().createQuery("FROM PorcentajesRangoedad");
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

	/*
	 * metodo para obtener el nombre del pais ganador de la gala anterior
	 */
	public String getPaisGanador() {
		String ganador = null;
		Session session = null;

		try {
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT PAIS_GANADOR FROM RESULTADOS_EUROVISION ORDER BY ID_RESULTADOS_EUROVISION DESC LIMIT 1;");

			Query<String> query = session.createSQLQuery(sb.toString());
			ganador = query.uniqueResult();

			if (ganador == null) {
				// la tabla esta vacia, cambiamos el String para que al concatenar la ruta para
				// pintar el logo tire del generico
				ganador = "Eurovision";

			}
			session.getTransaction().commit();

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
		return ganador;

	}

	/*
	 * metodo para borrar todos los registros de la tabla RESULTADOS_FASE_NACIONAL.
	 */
	public void deleteResultadosFaseNacional() {
		Session session = null;

		try {
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();

			StringBuffer sb = new StringBuffer();
			sb.append("DELETE FROM RESULTADOS_FASE_NACIONAL;");

			session.createSQLQuery(sb.toString()).executeUpdate();
			session.getTransaction().commit();

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

	}

	/*
	 * metodo para cerrar el pool de conexiones cuando se termine de usar
	 */
	public void cerrarPoolConexiones() {
		try {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public SessionFactory inicializarPoolConexiones() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			this.sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sessionFactory;
	}

}
