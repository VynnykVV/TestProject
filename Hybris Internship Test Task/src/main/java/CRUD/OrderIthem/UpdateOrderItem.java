package CRUD.OrderIthem;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import POJO.OrderItem;
import POJO.TimePK;
import util.HibernateUtility;

public class UpdateOrderItem {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public void update(List<Integer> list) {
		session.beginTransaction();
		OrderItem result = session.get(OrderItem.class, new TimePK(list.get(0), list.get(1)));
		result.setQuantity(list.get(2));
		session.getTransaction().commit();
		System.out.println(result + " updated!");
	}
}
