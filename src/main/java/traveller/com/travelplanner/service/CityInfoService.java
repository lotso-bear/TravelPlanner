package traveller.com.travelplanner.service;

import traveller.com.travelplanner.dao.CityInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.com.travelplanner.entity.Attraction;
import traveller.com.travelplanner.entity.City;

import java.util.List;

@Service
public class CityInfoService {

    @Autowired
    private CityInfoDao cityInfoDao;

    public List<City> getCities() {
        return cityInfoDao.getCities();
    }

    public List<Attraction> getAllAttractionItem(int CityTableId) {
        return cityInfoDao.getAllAttractionItem(CityTableId);
    }

    public double getLongitude(int CityTableId){
        return cityInfoDao.getLongitude(CityTableId);
    }

    public double getLatitude(int CityTableId){
        return cityInfoDao.getLatitude(CityTableId);
    }

    public Attraction getAttractionItem(int id) {
        return cityInfoDao.getAttractionItem(id);
    }
}