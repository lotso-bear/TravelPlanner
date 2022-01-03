package traveller.com.travelplanner.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import traveller.com.travelplanner.entity.City;
import traveller.com.travelplanner.entity.Customer;
import traveller.com.travelplanner.entity.VisitPlan;
import traveller.com.travelplanner.service.VisitPlanService;

import java.util.List;

@Controller
public class VisitPlanController {
    @Autowired
    VisitPlanService visitPlanService;

    @RequestMapping(value = "/createVisitPlan", method = {RequestMethod.GET, RequestMethod.POST})
    public VisitPlan createVisitPlan() {
        return visitPlanService.createVisitPlan();
    }

    @RequestMapping(value = "/visitPlan/{visitPlanId}", method = RequestMethod.GET)
    @ResponseBody
    public VisitPlan getVisitPlan(@PathVariable("visitPlanId") int visitPlanId) {
        return visitPlanService.getVisitPlan(visitPlanId);
    }

    @RequestMapping(value = "/visitPlans", method = RequestMethod.GET)
    @ResponseBody
    public List<VisitPlan> getAllVisitPlans() {
        return visitPlanService.getAllVisitPlans();
    }

    @RequestMapping(value = "/saveVisitPlan", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveVisitPlan(@RequestBody VisitPlan visitPlan) {
        visitPlanService.saveVisitPlan(visitPlan);
    }
}
