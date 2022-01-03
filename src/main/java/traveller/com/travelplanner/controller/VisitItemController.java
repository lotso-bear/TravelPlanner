package traveller.com.travelplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import traveller.com.travelplanner.service.VisitItemService;

@Controller
public class VisitItemController {
    @Autowired
    private VisitItemService visitItemService;

    @RequestMapping(value = "/visit/{visitPlanId}/{attractionId}/{date}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addVisitItemToPlan(@PathVariable("visitPlanId") int visitPlanId, @PathVariable("attractionId") int attractionId, String date) {
        visitItemService.saveVisitItem(visitPlanId, attractionId, date);
    }
}
