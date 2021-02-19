package views;

import java.util.List;

import CRUD.Product.SelectProduct;
import POJO.Product;

public class ProductView {
	
	public void showAll() {
		List<Product> listAll = new SelectProduct().selectAll();
		 
		String leftAlignFormat = "| %-15s | %-15s  | %-15s  |%n";

		System.out.format("+-----------------+------------------+------------------+%n");
		System.out.format("|   Product Name  |   Product Price  |  Product Status  |%n");
		System.out.format("+-----------------+------------------+------------------+%n");
		
		for(Product product: listAll) {
			System.out.format(leftAlignFormat, product.getName(),product.getPrice(),product.getStatus());	 
		}
		System.out.format("+-----------------+------------------+------------------+%n");
		
		
		
		
		
		
		
		
	 
		
		
	}
}
