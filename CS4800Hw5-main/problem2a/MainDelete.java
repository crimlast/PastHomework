package problem2a;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			//create objects
			Professor prof = (Professor)session.get(Professor.class, 1);
			Customer customer = (Customer) session.get(Customer.class, 1);
			
				
			session.delete(prof);
			session.delete(customer);
			
			session.getTransaction().commit();
			
			
		}finally {
			sessionFactory.close();
		}
	}

}
