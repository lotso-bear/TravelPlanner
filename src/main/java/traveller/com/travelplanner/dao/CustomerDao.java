package traveller.com.travelplanner.dao;

import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.Authorities;
import traveller.com.travelplanner.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomer (String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
