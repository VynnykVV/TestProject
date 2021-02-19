package operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;

import POJO.Product;
import POJO.product_status;

public class CreateProduct {
	private String name;
	private int price;
	private product_status productStatus;
	private Timestamp createdAt;
	
	public void newProduct() throws IOException {
		System.out.println("Creating new Product...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// product name
		while (true) {
			System.out.println("Product name: ");
			name = br.readLine();
			if (name == null || name.isEmpty() || name.isBlank()) {
				continue;
			} else {
				break;
			}
		}
		// product price
		while (true) {
			System.out.println("Product price: ");
			try {
				price = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				continue;
			}
			if (price == 0) {
				continue;
			}
			break;
		}
		// product status
		while (true) {
			
			System.out.println("Product status: ");
			System.out.println("\"out_of_stock, in_stock, running_low\"");
			String status = br.readLine();
			if(status.equals("out_of_stock")) {
				productStatus = product_status.out_of_stock;
				break;
			}else if(status.equals("in_stock")) {
				productStatus = product_status.in_stock;
				break;
			}else if(status.equals("running_low")) {
				productStatus = product_status.running_low;
				break;
			}
			continue;
		}
		//created now
		createdAt = new Timestamp(System.currentTimeMillis());

		//add new product
		Product product = new Product(name, price, productStatus, createdAt);
		new CRUD.Product.CreateProduct().add(product);
		System.out.println(product+" is Added!");

	}

}
