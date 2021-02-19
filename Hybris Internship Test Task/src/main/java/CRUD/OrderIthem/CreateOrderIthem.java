package CRUD.OrderIthem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJO.OrderItem;
import POJO.TimePK;
import util.HibernateUtility;

public class CreateOrderIthem {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public TimePK add(OrderItem orderIthem) {
		TimePK id;
		session.beginTransaction();
		id = (TimePK) session.save(orderIthem);
		session.getTransaction().commit();
		return id;
	}

}
