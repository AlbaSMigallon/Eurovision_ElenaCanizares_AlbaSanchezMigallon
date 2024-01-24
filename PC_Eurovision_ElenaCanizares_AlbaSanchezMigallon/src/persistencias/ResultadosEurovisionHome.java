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
 * Home object for domain model class ResultadosEurovision.
 * @see persistencias.ResultadosEurovision
 * @author Hibernate Tools
 */
public class ResultadosEurovisionHome {

	private static final Logger logger = Logger.getLogger(ResultadosEurovisionHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ResultadosEurovision transientInstance) {
		logger.log(Level.INFO, "persisting ResultadosEurovision instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ResultadosEurovision instance) {
		logger.log(Level.INFO, "attaching dirty ResultadosEurovision instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(ResultadosEurovision instance) {
		logger.log(Level.INFO, "attaching clean ResultadosEurovision instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(ResultadosEurovision persistentInstance) {
		logger.log(Level.INFO, "deleting ResultadosEurovision instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public ResultadosEurovision merge(ResultadosEurovision detachedInstance) {
		logger.log(Level.INFO, "merging ResultadosEurovision instance");
		try {
			ResultadosEurovision result = (ResultadosEurovision) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public ResultadosEurovision findById(int id) {
		logger.log(Level.INFO, "getting ResultadosEurovision instance with id: " + id);
		try {
			ResultadosEurovision instance = (ResultadosEurovision) sessionFactory.getCurrentSession()
					.get("persistencias.ResultadosEurovision", id);
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

	public List findByExample(ResultadosEurovision instance) {
		logger.log(Level.INFO, "finding ResultadosEurovision instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("persistencias.ResultadosEurovision")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
