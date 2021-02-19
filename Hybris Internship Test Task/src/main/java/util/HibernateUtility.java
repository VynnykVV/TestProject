package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import POJO.Order;
import POJO.OrderItem;
import POJO.Product;

public class HibernateUtility {

	public static SessionFactory factory;

	private HibernateUtility() {
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			factory = new Configuration()
					.configure()
					.addAnnotatedClass(Order.class)
					.addAnnotatedClass(Product.class)
					.addAnnotatedClass(OrderItem.class)
					.buildSessionFactory();
		}
		return factory;
	}
}