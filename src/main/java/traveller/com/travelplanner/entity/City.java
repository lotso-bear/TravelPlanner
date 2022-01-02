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
    private int CityTableId;


    private String name;


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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
