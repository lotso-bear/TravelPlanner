package traveller.com.travelplanner.entity;

import traveller.com.travelplanner.entity.Attraction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "city")
public class City implements Serializable {
    private static final long serialVersionUID = 2455760938054036111L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CityTableId;

    private double longitude;

    private double latitude;


    private String name;
    private String lat;
    private String lng;
    private String state;

    private String imageUrl;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Attraction> attractionList;

    public List<Attraction> getAttractionsTableList() {
        return attractionList;
    }

    public void setAttractionsTableList(List<Attraction> attractionsTableList) {
        this.attractionList = attractionsTableList;
    }

    public int getCityTableId() {
        return CityTableId;
    }

    public void setCityTableId(int cityTableId) {
        CityTableId = cityTableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude(){return longitude;}

    public double getLatitude(){return latitude;}


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
