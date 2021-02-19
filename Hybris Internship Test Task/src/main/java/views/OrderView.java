package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import CRUD.Order.SelectOrder;
import CRUD.OrderIthem.SelectOrderIthem;
import CRUD.Product.SelectProduct;
import POJO.Order;
import POJO.Product;
import util.JDBCConnection;

public class OrderView {

	public void showProductsQuntity() throws SQLException {
		String leftAlignFormat = "| %-15s | %-15s  |%n";
		Statement statemet = JDBCConnection.getConnection().createStatement();
		String sql = "Select products.name, SUM(order_items.quantity) AS Quantity\r\n" + "FROM products\r\n"
				+ "INNER JOIN order_items ON products.id=order_items.product_id\r\n" + "GROUP BY products.name\r\n"
				+ "ORDER BY Quantity DESC\r\n";
		ResultSet rs = statemet.executeQuery(sql);

		System.out.format("+-----------------+------------------+%n");
		System.out.format("|   Product Name  | Product Quanity  |%n");
		System.out.format("+-----------------+------------------+%n");

		while (rs.next()) {
			System.out.format(leftAlignFormat, rs.getString("products.name"), rs.getString("Quantity"));

		}
		System.out.format("+-----------------+------------------+%n");
	}

	public void showTotalOrderPrice() {
		String leftAlignFormat = "| %-15s | %-20s  | %-20s  | %-20s  | %-20s  |%n";
		System.out.format("+-----------------+-----------------------+-----------------------+-----------------------+-----------------------+%n");
		System.out.format("|	OrderID	  | Products Total Price  |	 Product Name 	  |	Product Quantity  | Order Create Date	  |%n");
		System.out.format("+-----------------+-----------------------+-----------------------+-----------------------+-----------------------+%n");
		List<Order> orders = new SelectOrder().selectAll();
		
		for(Order order: orders) {
			for(Product product: order.getProducts()) {
				SelectOrderIthem soi = new SelectOrderIthem();
				int quantity = soi.select(order.getId(), product.getId()).getQuantity();
				System.out.format(leftAlignFormat, order.getId(), product.getPrice()*quantity, product.getName(),quantity, order.getCreatedAt().subSequence(0, order.getCreatedAt().lastIndexOf(':')));	
			}
			
 		}
		System.out.format("+-----------------+-----------------------+-----------------------+-----------------------+-----------------------+%n");
		
	}

	 
}
