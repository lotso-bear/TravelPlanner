package com.example.travelplandemo1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "citiesTable")
public class CitiesTable implements Serializable {
    private static final long serialVersionUID = 2455760938054036111L;

    @Id
    private int CityTableId;


    private String name;


    private String imageUrl;
    @OneToMany(mappedBy = "citiesTable", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AttractionsTable> attractionsTableList;

    public List<AttractionsTable> getAttractionsTableList() {
        return attractionsTableList;
    }

    public void setAttractionsTableList(List<AttractionsTable> attractionsTableList) {
        this.attractionsTableList = attractionsTableList;
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
