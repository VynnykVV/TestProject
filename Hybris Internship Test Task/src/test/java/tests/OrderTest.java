package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import CRUD.Order.CreateOrder;
import CRUD.Order.SelectOrder;
import CRUD.Order.UpdateOrder;
import POJO.Order;

class OrderTest {

	@Test
	void testAdd() {
		Set<Integer> ids = new HashSet<Integer>();
		int id = 0;
		Order order = new Order("TestReady", new Timestamp(System.currentTimeMillis()).toString());
		ids.add(3);
		id = new CreateOrder().add(order, ids);
		assertTrue(id > 0);
	}

	@Test
	void testAddWrongIDs() {
		Set<Integer> ids = new HashSet<Integer>();
		Order order = new Order("TestReady", new Timestamp(System.currentTimeMillis()).toString());
		ids.add(0);
		assertNull(new CreateOrder().add(order, ids));
	}

	@Test
	void testSelectAll() {	
		assertNotNull(new SelectOrder().selectAll());
	}
	
	@Test
	void testUpdateOrder() {
		Order order = new Order("TestReady", new Timestamp(System.currentTimeMillis()).toString());	
		new UpdateOrder().add(order);
		assertNotEquals(0, order.getId());
	}

}
