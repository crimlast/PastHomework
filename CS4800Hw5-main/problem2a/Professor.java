package problem2a;
import javax.persistence.*;
	
@Entity
@Table(name="professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "office_number")
	private String office_Number;
	
	@Column(name = "research_area")
	private String research_Area;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Professor(String officeNum, String research, Customer customer) {
		office_Number = officeNum;
		research_Area = research;
		this.customer = customer;
	}
	
	public Professor() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setOfficeNumber(String officeNum) {
		office_Number = officeNum;
	}
	public void setResearchArea(String research) {
		research_Area = research;
	}
	public String getOfficeNumber() {
		return office_Number;
	}
	public String getResearchArea() {
		return research_Area;
	}
	public void setCustomer(Customer cus) {
		customer = cus;
	}
}
