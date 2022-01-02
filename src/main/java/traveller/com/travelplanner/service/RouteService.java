package traveller.com.travelplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.com.travelplanner.dao.RouteDao;

@Service
public class RouteService {

    @Autowired
    private RouteDao routeDao;

    public String[] getRoute(String[] attractions) {
        return routeDao.generateRoute(attractions);
    }

}
