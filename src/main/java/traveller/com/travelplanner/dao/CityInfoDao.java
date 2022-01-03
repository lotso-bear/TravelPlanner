package traveller.com.travelplanner.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.City;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CityInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<City> getCities() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(City.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
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

    public Double getLongitude(int CityTableId){
        try (Session session = sessionFactory.openSession()) {
            City city = session.get(City.class, CityTableId);
            if (city != null) {
                return city.getLongitude();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Double getLatitude(int CityTableId){
        try (Session session = sessionFactory.openSession()) {
            City city = session.get(City.class, CityTableId);
            if (city != null) {
                return city.getLatitude();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
