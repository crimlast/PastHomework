package problem2b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainCreateProduct {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().
			configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).
			addAnnotatedClass(Product.class).buildSessionFactory();
	
		Session session = sessionFactory.getCurrentSession();
	
		try {
			session.beginTransaction();
			
			//create objects
			Product cake = new Product("cake");
						
			session.save(cake);
			
			Order order1 = new Order("Order1");
			
			session.save(cake);		
			
			order1.addProduct(cake);
			cake.addOrder(order1);
			
		
			session.getTransaction().commit();
	
		}finally {
			sessionFactory.close();
		}

	}
}
	


