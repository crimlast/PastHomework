package problem2b;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class MainDeleteProducty {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).
				addAnnotatedClass(Product.class).buildSessionFactory();
		
			Session session = sessionFactory.getCurrentSession();
		
			try {
				session.beginTransaction();
				
				//create objects
				Product cake = session.get((Product.class), 1);
				
				session.delete(cake);
			
				
			
				session.getTransaction().commit();
		
			}finally {
				sessionFactory.close();
			}

	}
		




}
