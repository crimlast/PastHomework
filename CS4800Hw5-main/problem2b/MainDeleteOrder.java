package problem2b;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class MainDeleteOrder {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).
				addAnnotatedClass(Product.class).buildSessionFactory();
		
			Session session = sessionFactory.getCurrentSession();
		
			try {
				session.beginTransaction();
				
				//create objects
				Order order1 = session.get(Order.class, 1);
				
				session.delete(order1);
			
				
			
				session.getTransaction().commit();
		
			}finally {
				sessionFactory.close();
			}

	}
		




}
