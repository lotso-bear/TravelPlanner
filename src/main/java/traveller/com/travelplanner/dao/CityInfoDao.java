package traveller.com.travelplanner.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.City;
import traveller.com.travelplanner.entity.VisitItem;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CityInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(City city) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) session.close();
        }
    }

    public List<City> getCities() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(City.class);
            Projection projection = Projections.property("CityTableId");
            Projection projection2 = Projections.property("name");
            Projection projection3 = Projections.property("state");
            Projection projection4 = Projections.property("lat");
            Projection projection5 = Projections.property("lng");
            ProjectionList pList = Projections.projectionList();
            pList.add(projection);
            pList.add(projection2);
            pList.add(projection3);
            pList.add(projection4);
            pList.add(projection5);
            criteria.setProjection(pList);
            List list = criteria.list();
            return  list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }


    public List<Attraction> getAllAttractionItem(int CityTableId) {
        try (Session session = sessionFactory.openSession()) {
            City city = session.get(City.class, CityTableId);
            if (city != null) {
                return city.getAttractionsTableList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Attraction getAttractionItem(int AttractionsTableId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Attraction.class, AttractionsTableId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
