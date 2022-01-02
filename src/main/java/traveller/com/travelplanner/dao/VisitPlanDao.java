package traveller.com.travelplanner.dao;

import traveller.com.travelplanner.entity.VisitPlan;
import traveller.com.travelplanner.entity.VisitItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;

@Repository
public class VisitPlanDao {
    @Autowired
    private SessionFactory sessionFactory;

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
