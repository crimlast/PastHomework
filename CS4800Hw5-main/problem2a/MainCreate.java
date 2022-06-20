package problem2a;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MainCreate {
	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
	
		Session session = sessionFactory.getCurrentSession();
		try {
			//create objects
			Customer customer = new Customer("Bob", "Cal Poly Pomona");
		
			Professor prof = new Professor("Math", "B4", customer);
		
			session.beginTransaction();
		
			session.save(prof);
		
			session.getTransaction().commit();
		
		}finally {
			sessionFactory.close();
		}
		
	}
}
