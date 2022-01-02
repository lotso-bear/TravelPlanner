package traveller.com.travelplanner.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import traveller.com.travelplanner.entity.VisitPlan;
import traveller.com.travelplanner.service.VisitPlanService;

@Controller
public class VisitPlanController {
    @Autowired
    private VisitPlanService visitPlanService;

    @RequestMapping(value = "/visitPlan", method = RequestMethod.GET)
    @ResponseBody
    public VisitPlan getVisitPlan(){
        return visitPlanService.getVistPlan();
    }
}
