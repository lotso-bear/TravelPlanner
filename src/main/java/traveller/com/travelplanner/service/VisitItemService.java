package traveller.com.travelplanner.service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import traveller.com.travelplanner.dao.VisitItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.Customer;
import traveller.com.travelplanner.entity.VisitItem;
import traveller.com.travelplanner.entity.VisitPlan;

@Service
public class VisitItemService {
    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private VisitPlanService visitPlanService;

    @Autowired
    private VisitItemDao visitItemDao;

    public void saveVisitItem(int visitPlanId, int attractionID, String date) {
        Attraction attractionItem = cityInfoService.getAttractionItem(attractionID);
        VisitPlan visitPlan = visitPlanService.getVisitPlan(visitPlanId);
        for (VisitItem visit : visitPlan.getVisitItemList()) {
            try {
                if (visit.getDate().equals(date) && visit.getAttraction().getAttractionID() == attractionID) {
                    return;
                }
            } catch (Exception ex) {
                continue;
            }
        }
        VisitItem visitItem = new VisitItem();
        visitItem.setAttraction(attractionItem);
        visitItem.setVisitPlan(visitPlan);
        visitItem.setDate(date);
        visitItemDao.save(visitItem);
    }
}
