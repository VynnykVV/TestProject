package tests;

 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

 
import CRUD.OrderIthem.SelectOrderIthem;
import CRUD.OrderIthem.UpdateOrderItem;
import POJO.OrderItem;
 

public class OrderIthemTest {
	/*
	@Test
	void testCreateOrder() {
		OrderItem oi = new OrderItem(1, 1, 1);
		assertNotNull(new CreateOrderIthem().add(oi));
	}
	*/
	@Test
	void testSelectOrderIthemAll() {
		SelectOrderIthem  oi = new SelectOrderIthem();
		assertNotNull(oi.selectAll());
	}
	
	@Test
	void testSelectOrderIthemSingle() {
		SelectOrderIthem  oi = new SelectOrderIthem();
		assertNotNull(oi.select(1, 1));
	}
	
	@Test
	void testUpdateOrderItem() {
		
		OrderItem oit = new SelectOrderIthem().select(1, 1);
		
		int quantity = oit.getQuantity();
		List<Integer> list= new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(quantity+10);
		UpdateOrderItem  oi = new UpdateOrderItem();
		oi.update(list);
		assertEquals(quantity+10, new SelectOrderIthem().select(1, 1).getQuantity());
 
	}
}
