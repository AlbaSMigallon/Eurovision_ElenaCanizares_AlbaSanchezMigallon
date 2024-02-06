package controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import persistencias.Cantantes;
import persistencias.PorcentajesRangoedad;
import persistencias.ResultadosEurovision;
import persistencias.ResultadosFaseNacional;
import java.util.List;

/**
 * Clase utilizada para gestionar datos. Utilizamos instancias con patron Singleton para poder trabajar desde todas
 * partes del proyecto con el mismo
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 */
public class GestionDeDatos {

	// Pool de conexiones
	private SessionFactory sessionFactory;
	// Seccion critica
	private static Object object = new Object();
	// Patron Singleton
	private static GestionDeDatos instance;

	/**
	 * Constructor de la clase "GestionDeDatos"
	 */
	public GestionDeDatos() {
		super();
		this.sessionFactory = null;
		this.sessionFactory = inicializarPoolConexiones();
	}

	/**
	 * Funcionalidad que verifica si la instancia de la clase es null, en cuyo caso crea una nueva y la asigna al
	 * atributo de instancia "instance"
	 */
	private synchronized static void createInstance() {
		if (null == instance) {
			instance = new GestionDeDatos();
		}
	}

	/**
	 * Funcionalidad que devuelve la instancia unica de la clase
	 * @return instance
	 */
	public static GestionDeDatos getInstance() {
		if (null == instance) {
			createInstance();
		}
		return instance;
	}

	/**
	 * Funcionalidad que busca un cantante en la tabla "CANTANTES" basandose en el nombre del cantante proporcionado
	 * como parametro y devuelve el pais asociado a dicho cantante
	 * @param nombreParametro
	 * @return pais
	 */
	public String getPaisCantante(String nombreParametro) {
		Session session = null;
		String pais = "";
		synchronized (object) {
			try {
				session = this.sessionFactory.getCurrentSession();
				session.beginTransaction();
				Query<?> query = session.createQuery("FROM Cantantes c WHERE c.nombre = :variableNombre");
				query.setParameter("variableNombre", nombreParametro);
				Cantantes cantante = (Cantantes) query.getSingleResult();
				 pais = cantante.getPais();
				
			}
			catch(HibernateException e) {
				e.printStackTrace();
				if (null != session) {
					session.getTransaction().rollback();
				}
				throw e;
			}
			finally {
				if (null != session) {
					session.close();
				}
			}
			return pais;
		}
	}

	/**
	 * Funcionalidad que recupera todos los registros de la tabla "CANTANTES" y devuelve una lista de objetos Cantantes
	 * @return cantantes
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * Funcionalidad que busca un cantante en la tabla "CANTANTES" basandose en el nombre del pais pasado como parametro
	 * y devuelve dicho cantantes
	 * @param nombrePais
	 * @return cantante
	 */
	@SuppressWarnings("unchecked")
	public Cantantes getCantantePorPais(String nombrePais) {
	    Session session = null;
	    Cantantes cantante = null;
	    synchronized (object) {
	        try {
	            session = this.sessionFactory.getCurrentSession();
	            session.beginTransaction();
				Query<Cantantes> query = session.createQuery("FROM Cantantes c WHERE c.pais = :nombrePais");
	            query.setParameter("nombrePais", nombrePais);
	            cantante = query.getSingleResult();
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
	        return cantante;
	    }
	}

	/**
	 * Funcionalidad que inserta o actualiza un objeto ResultadosEurovision en la base de datos utilizando Hibernate
	 * @param resultado
	 */
	public void insertResultadosEurovision(ResultadosEurovision resultado) {
		Session session = null;
		synchronized (object) {
			try {
				session = this.sessionFactory.getCurrentSession();
				session.beginTransaction();
				System.out.println("INSERT FINAL: "+ resultado);
				session.saveOrUpdate(resultado);// Cambios Elena y Alba martes
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

	/**
	 * Metodo para hacer el insert en la tabla de RESULTADOS_FASE_NACIONAL. Un insert por cada pais
	 * @param resultado
	 */
	public void insertResultadosFaseNacional(ResultadosFaseNacional resultado) {
		Session session = null;
		// Controlar el acceso al recurso compartido
		synchronized (object) {
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
	}

	/**
	 * Metodo para sacar los registro de los rangos de edad para calcular las votaciones nacionales
	 * @return paises
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * Metodo para obtener el nombre del pais ganador de la gala anterior
	 * @return ganador
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * Metodo que busca todos los registros de la tabla ResultadosFaseNacional
	 * @return resultados
	 */
	public List<ResultadosFaseNacional> getResultadosFaseNacional() {
	    Session session = null;
	    List<ResultadosFaseNacional> resultados = null;
	    synchronized (object) {
	        try {
	            session = this.sessionFactory.getCurrentSession();
	            session.beginTransaction();
	            Query<ResultadosFaseNacional> query = session.createQuery("FROM ResultadosFaseNacional", ResultadosFaseNacional.class);
	            resultados = query.getResultList();
	          
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

	/**
	 * Metodo para borrar todos los registros de la tabla RESULTADOS_FASE_NACIONAL.
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

	/**
	 * Metodo para cerrar el pool de conexiones cuando se termine de usar
	 */
	public void cerrarPoolConexiones() {
		try {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Funcionalidad que inicializa y configurar una SessionFactory en Hibernate utilizando un archivo de
	 *  configuracion hibernate.cfg.xml
	 * @return sessionFactory
	 */
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
