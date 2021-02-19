package CRUD.Order;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJO.Order;
import POJO.Product;
import util.HibernateUtility;

public class CreateOrder {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();
	Product product;

	public Integer add(Order order, Set<Integer> productIds) {
		int counter = 0;
		Integer id = null;
		try {
			session.beginTransaction();
			for (int productId : productIds) {
				product = session.get(Product.class, productId);
				if (product == null) {
					System.out.println("Product with id==" + productId + " is not found");
				} else {
					order.addProduct(product);
					counter++;
				}
			}
			if (counter == 0) {
				System.out.println("Products with provided ids are not found!");
				session.getTransaction().rollback();
			} else {
				id = (Integer) session.save(order);
				order.setUserId((order.getId() + 1) * 7);
				session.getTransaction().commit();
				System.out.println(order + " was added!");

			}

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return id;
	}

}