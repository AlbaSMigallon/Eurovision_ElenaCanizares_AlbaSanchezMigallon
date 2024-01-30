package controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import persistencias.Cantantes;
import persistencias.PorcentajesRangoedad;
import persistencias.ResultadosFaseNacional;

import java.util.List;

public class GestionDeDatos {
	/*
	 * Clase utilizada para gestionar datos. Utilizamos instancias con patron
	 * Singleton para poder trabajar desde todas partes del proyecto con el mismo
	 * pool de conexiones
	 */
	private SessionFactory sessionFactory;
	// Seccion critica
	private static Object object = new Object();

	// Patron Singleton
	private static GestionDeDatos instance;

	// trabajamos con el mismo session factory de la calse

	public GestionDeDatos() {
		super();
		this.sessionFactory = null;
		this.sessionFactory = inicializarPoolConexiones();
	}

	private synchronized static void createInstance() {
		if (null == instance) {
			instance = new GestionDeDatos();
		}
	}

	public static GestionDeDatos getInstance() {
		if (null == instance) {
			createInstance();
		}
		return instance;
	}

	/*
	 * metodo para hacer el insert en la tabla de RESULTADOS_FASE_NACIONAL. un
	 * insert por cada pais
	 */

	public void insertResultadosFaseNacional(ResultadosFaseNacional resultado) {
		Session session = null;
		// Controlar el acceso al recurso compartido
		synchronized (object) {

			try {
				session = this.sessionFactory.getCurrentSession();
				session.beginTransaction();

				session.save(resultado);////

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

	}

	/*
	 * metodo para sacar los registro de los rangos de edad para calcular las
	 * votaciones nacionales
	 */
	public List<PorcentajesRangoedad> getPorcentajes() {
		Session session = null;
		List<PorcentajesRangoedad> paises = null;

		synchronized (object) {

			try {
				session = this.sessionFactory.getCurrentSession();
				session.beginTransaction();

				Query<PorcentajesRangoedad> query = this.sessionFactory.getCurrentSession()
						.createQuery("FROM PorcentajesRangoedad");
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
	}

	public List<Cantantes> getCantantes() {

		Session session = null;
		List<Cantantes> cantantes = null;
		synchronized (object) {
			try {
				session = this.sessionFactory.getCurrentSession();
				session.beginTransaction();

				Query<Cantantes> query = this.sessionFactory.getCurrentSession().createQuery("FROM Cantantes");
				cantantes = query.list();
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

			return cantantes;
		}
	}

	/*
	 * metodo para obtener el nombre del pais ganador de la gala anterior
	 */
	public String getPaisGanador() {
		String ganador = "";
		Session session = null;
		synchronized (object) {
			try {
				session = this.sessionFactory.getCurrentSession();
				session.beginTransaction();

				StringBuffer sb = new StringBuffer();
				sb.append(
						"SELECT PAIS_GANADOR FROM RESULTADOS_EUROVISION ORDER BY ID_RESULTADOS_EUROVISION DESC LIMIT 1;");

				Query<String> query = session.createSQLQuery(sb.toString());
				ganador = query.uniqueResult();
				System.out.println("Ganador gala anterior: " + ganador);

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
	}

	// Metodo que busca todos los registros de la tabla ResultadosFaseNacional
	public List<ResultadosFaseNacional> getResultadosFaseNacional() {
	    Session session = null;
	    List<ResultadosFaseNacional> resultados = null;

	    synchronized (object) {
	        try {
	            session = this.sessionFactory.getCurrentSession();
	            session.beginTransaction();

	            Query<ResultadosFaseNacional> query = session.createQuery("FROM ResultadosFaseNacional", ResultadosFaseNacional.class);
	            resultados = query.getResultList();

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

	        return resultados;
	    }
	}

	/*
	 * metodo para borrar todos los registros de la tabla RESULTADOS_FASE_NACIONAL.
	 */
	public void deleteResultadosFaseNacional() {
		Session session = null;
		synchronized (object) {
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
