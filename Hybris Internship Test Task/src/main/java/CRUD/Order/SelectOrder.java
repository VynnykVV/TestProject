package CRUD.Order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import POJO.Order;
import util.HibernateUtility;

public class SelectOrder {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public List<Order> selectAll() {
		session.beginTransaction();
		List<Order> result = session.createQuery("From Order").getResultList();
		session.getTransaction().commit();
		return result;
	}

}
