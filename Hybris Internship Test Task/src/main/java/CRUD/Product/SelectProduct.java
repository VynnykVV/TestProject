package CRUD.Product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import POJO.Product;
import util.HibernateUtility;

public class SelectProduct {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public List<Product> selectAll() {
		session.beginTransaction();
		List<Product> result = session.createQuery("From Product").getResultList();
		session.getTransaction().commit();
		return result;
	}

}
