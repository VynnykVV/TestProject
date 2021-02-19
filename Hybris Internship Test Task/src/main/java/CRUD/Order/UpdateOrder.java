package CRUD.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJO.Order;

import util.HibernateUtility;

public class UpdateOrder {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public void add(Order order) {
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
	}

}