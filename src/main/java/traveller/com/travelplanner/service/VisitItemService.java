package traveller.com.travelplanner.service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import traveller.com.travelplanner.dao.VisitItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.Customer;
import traveller.com.travelplanner.entity.VisitItem;

@Service
public class VisitItemService {
    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VisitItemDao visitItemDao;

    public void saveVisitItem(int attractionID) {
        VisitItem visitItem = new VisitItem();
        Attraction attractionItem = cityInfoService.getAttractionItem(attractionID);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Customer customer = customerService.getCustomer(email);

        visitItem.setAttraction(attractionItem);
        visitItem.setVisitPlan(customer.getVisitPlan());

        visitItemDao.save(visitItem);
    }
}
