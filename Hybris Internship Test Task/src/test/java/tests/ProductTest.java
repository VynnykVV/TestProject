package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CRUD.Product.CreateProduct;
import CRUD.Product.RemoveProduct;
import CRUD.Product.SelectProduct;
import POJO.Order;
import POJO.Product;
import POJO.product_status;

class ProductTest {
	static Product product;

	@BeforeAll
	public static void setup() {
		product = new Product("TestPlate2", 99, product_status.out_of_stock, new Timestamp(System.currentTimeMillis()));
		product.setOrders(new ArrayList<Order>());
	}

	@Test
	void testAddProduct() {
		int id = new CreateProduct().add(product);
		product.setId(id);
		assertTrue(id > 0);
	}

	@Test
	void testSelectProduct() {
		new CreateProduct().add(product);
		List<Product> list = new SelectProduct().selectAll();
		assertTrue(list.contains(product));
	}

	@Test
	void testDeleteProduct() throws InterruptedException {
		InputStream sysInBackup = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream("dbDeletePassword".getBytes());
		final int id=new CreateProduct().add(product);
		System.setIn(in);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					new RemoveProduct().deleteById(id);
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
		});
		thread.start();
		thread.sleep(400);
		
		List<Product> list = new SelectProduct().selectAll();
		assertFalse(list.contains(product));
	}

}
