package problem2b;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
			name="orders_products",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private List<Product> products;
	
	public Order(String name) {
		this.name = name;
		products = new ArrayList<Product>();
	}
	
	public int getId() {
		return id;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void remove() {
		int i = products.size();
		if (i > 0) {
			products.remove(0);
		}
	}
}


