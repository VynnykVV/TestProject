package operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import POJO.Order;

public class CreateOrder {
	private String orderStatus;
	private Timestamp createdAt;
	private int id;
	private String tempId;
	Set<Integer> set;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void newOrder(Set<Integer> set) throws IOException {
		if (set.size() == 0) {
			System.out.println("No Products ids were added!");
			return;
		}

		while (true) {
			System.out.println("Order status: ");
			orderStatus = br.readLine();

			if (orderStatus == null || orderStatus.isEmpty() || orderStatus.isBlank()) {
				continue;
			} else {
				break;
			}
		}
		// created now
		createdAt = new Timestamp(System.currentTimeMillis());
		Order order = new Order(orderStatus, createdAt.toString());
		new CRUD.Order.CreateOrder().add(order, set);

	}

	public Set<Integer> parseId() throws IOException {
		System.out.println("Creating new Order...");
		System.out.println("Please enter product ids");
		System.out.println("When finished ented - \"Done\"");
		set = new HashSet<Integer>();
		while (true) {

			System.out.print("ID: ");
			tempId = br.readLine();
			if (tempId.equals("Done")) {
				break;
			}
			try {
				id = Integer.parseInt(tempId);
				set.add(id);
			} catch (Exception e) {
				continue;
			}
			if (id == 0) {
				continue;
			}

		}
		return set;
	}
}
