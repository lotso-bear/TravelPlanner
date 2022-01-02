//package traveller.com.travelplanner.service;
//
//import traveller.com.travelplanner.dao.VisitPlanDao;
//import traveller.com.travelplanner.entity.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import traveller.com.travelplanner.entity.VisitItem;
//import traveller.com.travelplanner.entity.VisitPlan;
//
//@Service
//public class VisitPlanService {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private VisitPlanDao visitPlanDao;
//
//    public VisitPlan getVistPlan() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Customer customer = customerService.getCustomer(email);
//
//        if (customer != null) {
//            VisitPlan visitPlan = customer.getVisitPlan();
//            return visitPlan;
//        }
//        return new visitPlan();
//    }
//
//    public void cleanCart() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Customer customer = customerService.getCustomer(email);
//        if (customer != null)
//            visitPlanDao.removeAllVisitItems(getVistPlan());
//    }
//}
