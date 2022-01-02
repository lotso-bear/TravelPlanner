package traveller.com.travelplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.City;
import traveller.com.travelplanner.service.CityInfoService;

import java.util.List;

@Controller
public class CityInfoController {
    @Autowired
    private CityInfoService cityInfoService;

    @RequestMapping(value = "/city/{CityTableId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<Attraction> getMenus(@PathVariable("CityTableId") int CityTableId) {
        return cityInfoService.getAllAttractionItem(CityTableId);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getCities() {
        return cityInfoService.getCities();
    }
}
