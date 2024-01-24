package persistencias;
// Generated 24 ene 2024 13:59:21 by Hibernate Tools 5.4.33.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ResultadosFaseNacional.
 * @see persistencias.ResultadosFaseNacional
 * @author Hibernate Tools
 */
public class ResultadosFaseNacionalHome {

	private static final Logger logger = Logger.getLogger(ResultadosFaseNacionalHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ResultadosFaseNacional transientInstance) {
		logger.log(Level.INFO, "persisting ResultadosFaseNacional instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ResultadosFaseNacional instance) {
		logger.log(Level.INFO, "attaching dirty ResultadosFaseNacional instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(ResultadosFaseNacional instance) {
		logger.log(Level.INFO, "attaching clean ResultadosFaseNacional instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(ResultadosFaseNacional persistentInstance) {
		logger.log(Level.INFO, "deleting ResultadosFaseNacional instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public ResultadosFaseNacional merge(ResultadosFaseNacional detachedInstance) {
		logger.log(Level.INFO, "merging ResultadosFaseNacional instance");
		try {
			ResultadosFaseNacional result = (ResultadosFaseNacional) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public ResultadosFaseNacional findById(java.lang.String id) {
		logger.log(Level.INFO, "getting ResultadosFaseNacional instance with id: " + id);
		try {
			ResultadosFaseNacional instance = (ResultadosFaseNacional) sessionFactory.getCurrentSession()
					.get("persistencias.ResultadosFaseNacional", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(ResultadosFaseNacional instance) {
		logger.log(Level.INFO, "finding ResultadosFaseNacional instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("persistencias.ResultadosFaseNacional")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
