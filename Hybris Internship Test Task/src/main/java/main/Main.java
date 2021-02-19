package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import CRUD.Product.RemoveProduct;
import views.OrderView;
import views.ProductView;
import operations.CreateOrder;
import operations.CreateProduct;
import operations.UpdateOrderEntriesQuantities;

public class Main {
	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("Aplication is started!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> ids;
		Set<Integer> setId;
		String help = "Use following commands: \n" + "1)Create Product\r\n" + "2)Create Order\r\n"
				+ "3)Update Order quantity\r\n" + "4)Show view A\r\n" + "5)Show view B\r\n" + "6)Show view C\r\n"
				+ "7)Remove product by ID\r\n" + "8)Remove all products\r\n";

		System.out.println(help);
		while (true) {
			switch (br.readLine()) {
			case "Create Product":
				new CreateProduct().newProduct();
				continue;
			case "Create Order":
				setId = new CreateOrder().parseId();
				new CreateOrder().newOrder(setId);
				continue;
			case "Update Order quantity":
				ids = new UpdateOrderEntriesQuantities().parseId();
				new UpdateOrderEntriesQuantities().update(ids);
				continue;
			case "Show view A":
				new ProductView().showAll();
				continue;
			case "Show view B":
				new OrderView().showProductsQuntity();
				continue;
			case "Show view C":
				new OrderView().showTotalOrderPrice();
				continue;
			case "Remove product by ID":
				new RemoveProduct().deleteSingle();
				continue;
			case "Remove all products":
				new RemoveProduct().deleteAll();
				continue;
			default:
				continue;
			}

		}

	}
}
