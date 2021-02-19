package CRUD.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import POJO.Product;
import util.HibernateUtility;

public class CreateProduct {
	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.getCurrentSession();

	public int add(Product product) {
		int id;
		session.beginTransaction();
		id = (int) session.save(product);
		session.getTransaction().commit();
		return id;
	}

}
