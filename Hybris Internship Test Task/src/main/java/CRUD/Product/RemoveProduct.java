package CRUD.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
import java.util.List;
import java.util.Scanner;
 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import POJO.Order;
import POJO.OrderItem;
import POJO.Product;

public class RemoveProduct {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private int id;
	SessionFactory factory;
	public RemoveProduct() throws IOException{
		generateConfig();
	}
	public void generateConfig() throws IOException {
		String password = parsePassword();	
		try {
			 factory = new Configuration().configure()
					.setProperty("hibernate.connection.username", "dbDeleteUser")
					.setProperty("hibernate.connection.password", password).addAnnotatedClass(Order.class)
					.addAnnotatedClass(Product.class)
					.addAnnotatedClass(OrderItem.class)
					.buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Sorry wrong password, try again");
			return;
		}
	}
	
	
	public void deleteById(int id) throws IOException {
			if(factory == null) {
				return;
			}
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Product product = session.get(Product.class, id);
			if (product == null) {
				System.out.println("Product with ID =" + id + " is not found!");
			} else {
				System.out.println("Deleting " + product + "...");
				session.delete(product);
				System.out.println("Done!");
			}
			session.getTransaction().commit();
	}

	public int parseId() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Product id:");
		while (!sc.hasNextInt()) {

			sc.next();
		}
		return sc.nextInt();
	}

	public String parsePassword() throws IOException {
		String password;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Please enter password:");
			password = br.readLine();
			if (password == null || password.isEmpty() || password.isBlank()) {
				continue;
			} else {
				break;
			}
		}
		return password;
	}
	
	public void deleteSingle() throws IOException {
		if(factory == null) {
			return;
		}
		deleteById(parseId());
	}
	public void deleteAll() throws IOException {
		if(factory == null) {
			return;
		}
		List<Integer> list;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		 
		list = session.createQuery("SELECT mt.id FROM Product mt").list();
		session.getTransaction().commit();
		for(Integer id: list) {
			deleteById(id);	
		}
		
	}
}
