package operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CRUD.OrderIthem.SelectOrderIthem;
import CRUD.OrderIthem.UpdateOrderItem;
import POJO.OrderItem;

public class UpdateOrderEntriesQuantities {
	public void update(List<Integer> list ) {
		OrderItem oi = new SelectOrderIthem().select(list.get(0), list.get(1));
		if (oi == null) {
			System.out.println("No such order or such product in order");
		} else {
	 
			new UpdateOrderItem().update(list);
			

		}
	}

	public List<Integer> parseId() throws IOException {

		List<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Order id:");
		while (!sc.hasNextInt()) {
			
			sc.next();
		}
		list.add(sc.nextInt());
		System.out.println("Please enter Product id:");
		while (!sc.hasNextInt()) {
			sc.next();
		}
		list.add(sc.nextInt());
		System.out.println("Please enter new quantity:");
		while (!sc.hasNextInt()) {
			
			sc.next();
		}
		list.add(sc.nextInt());
		
		return list;
	}
}
