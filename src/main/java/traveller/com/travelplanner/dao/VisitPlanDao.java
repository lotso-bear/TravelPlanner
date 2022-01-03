package traveller.com.travelplanner.dao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import traveller.com.travelplanner.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import traveller.com.travelplanner.service.CustomerService;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public class VisitPlanDao {
    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private CustomerService customerService;

    public void createVisitPlan(VisitPlan visitPlan) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(visitPlan);
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

    public VisitPlan getVisitPlan(int visitPlanId) {
        try (Session session = sessionFactory.openSession()) {
            VisitPlan visitPlan = session.get(VisitPlan.class, visitPlanId);
            if (visitPlan != null) {
                return visitPlan;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new VisitPlan();
    }


    public List<VisitPlan> getAllVisitPlans(String email) {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, email);
            if (customer != null) {
                List<VisitPlan> list = customer.getVisitPlan();
                // Create a new LinkedHashSet
                Set<VisitPlan> set = new LinkedHashSet<>();
                // Add the elements to set
                set.addAll(list);
                // Clear the list
                list.clear();
                // add the elements of set
                // with no duplicates to the list
                list.addAll(set);
                return list;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void removeVisitItem(int visitItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            VisitItem visitItem = session.get(VisitItem.class, visitItemId);
            VisitPlan visitPlan = visitItem.getVisitPlan();
            visitPlan.getVisitItemList().remove(visitItem);

            session.beginTransaction();
            session.delete(visitItem);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void removeAllVisitItems(VisitPlan visitPlan) {
        for (VisitItem visitItem : visitPlan.getVisitItemList()) {
            removeVisitItem(visitItem.getVisitItemId());
        }
    }

}
