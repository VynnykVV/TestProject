package POJO;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
 
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
@IdClass(TimePK.class)
public class OrderItem implements Serializable  {
	@Id
	@Column(name = "order_id")
	private int orderID;
	@Id
	@Column(name = "product_id")
	private int productID;
	
	@Column(name = "quantity")
	private int quantity;

	 
	
	public OrderItem() {
		
	}
	public OrderItem(int orderID, int productID, int quantity) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItem [orderID=" + orderID + ", productID=" + productID + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderID;
		result = prime * result + productID;
		result = prime * result + quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (orderID != other.orderID)
			return false;
		if (productID != other.productID)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
 
	

}
