package problem2b;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
			name="product_order",
			joinColumns=@JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="order_id")
			)
	private List<Order> orders;
	
	public Product(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public void remove() {
		int i = orders.size();
		if (i > 0) {
			orders.remove(0);
		}
	}
}
