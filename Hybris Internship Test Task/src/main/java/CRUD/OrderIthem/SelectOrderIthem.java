package CRUD.OrderIthem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import POJO.OrderItem;
import POJO.TimePK;
import util.HibernateUtility;

public class SelectOrderIthem {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public List<OrderItem> selectAll() {
		session.beginTransaction();
		List<OrderItem> result = session.createQuery("From OrderItem").getResultList();
		session.getTransaction().commit();
		return result;
	}

	public OrderItem select(int orderId, int productId) {
		session.beginTransaction();
		OrderItem result = session.get(OrderItem.class, new TimePK(orderId, productId));
		session.getTransaction().commit();
		return result;
	}

}
