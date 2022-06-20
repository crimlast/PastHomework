package problem2a;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;

	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public Customer() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}


}
