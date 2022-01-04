package traveller.com.travelplanner.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import traveller.com.travelplanner.dao.VisitItemDao;
import traveller.com.travelplanner.dao.VisitPlanDao;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import traveller.com.travelplanner.entity.VisitItem;
import traveller.com.travelplanner.entity.VisitPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VisitPlanService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VisitPlanDao visitPlanDao;

    @Autowired
    private VisitItemService visitItemService;

    public VisitPlan getVisitPlan(int visitPlanId) {
        return visitPlanDao.getVisitPlan(visitPlanId);
    }

    public List<VisitItem> shuffleVisitPlan(int visitPlanId, String date) {
        VisitPlan visitPlan = visitPlanDao.getVisitPlan(visitPlanId);
        List<VisitItem> visitItemList = visitPlan.getVisitItemList();
        List<VisitItem> visitItems = new ArrayList<>();
        // add visit items on that date to visitItems
        for (VisitItem visitItem : visitItemList) {
            if (visitItem.getDate().equals(date)) {
                visitItems.add(visitItem);
            }
        }
        Collections.shuffle(visitItems);
        return visitItems;
    }

    public List<VisitPlan> getAllVisitPlans() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return visitPlanDao.getAllVisitPlans(email);
    }

    public VisitPlan createVisitPlan(String city) {
        VisitPlan visitPlan = new VisitPlan();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Customer customer = customerService.getCustomer(email);
        visitPlan.setCustomer(customer);
        visitPlan.setCity(city);
        visitPlanDao.createVisitPlan(visitPlan);
        return visitPlan;
    }

    public void saveVisitPlan(VisitPlan visitPlan) {
        List<VisitItem> visitItemList = visitPlan.getVisitItemList();
        for (VisitItem visitItem : visitItemList) {
            visitItemService.saveVisitItem(visitPlan.getVisitPlanId(), visitItem.getAttraction().getAttractionID(), visitItem.getDate());
        }
    }

//    public void cleanCart() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Customer customer = customerService.getCustomer(email);
//        if (customer != null)
//            visitPlanDao.removeAllVisitItems(getVisitPlan());
//    }
}
