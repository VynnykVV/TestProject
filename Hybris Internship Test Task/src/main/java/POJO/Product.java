package POJO;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int price;
	
	@Column
	@Enumerated(EnumType.STRING)
	private product_status status;
	@Column(name = "created_at")
	private Timestamp createdAt;
	@ManyToMany(fetch = FetchType.EAGER, 
	cascade = CascadeType.REMOVE)
	@JoinTable(
			name = "order_items", 
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order> orders;
	
	

	public Product() {}
	
	public Product(String name, int price, product_status status, Timestamp createdAt) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public product_status getStatus() {
		return status;
	}
	public void setStatus(product_status status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
 

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + ", createdAt="
				+ createdAt +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + price;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Product other = (Product) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		 
		if (price != other.price)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
}
