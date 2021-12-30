package com.example.travelplandemo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attractionsTable")
public class AttractionsTable implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;
    @Id
    private int AttractionsTableId;

    private String name;

    private String description;

    private String imageUrl;

    private double longitude;

    private double latitude;

    @ManyToOne
    private VisitItemTable visitTable;

    public VisitItemTable getVisitTable() {
        return visitTable;
    }

    public void setVisitTable(VisitItemTable visitTable) {
        this.visitTable = visitTable;
    }

    @ManyToOne
    @JsonIgnore
    private CitiesTable citiesTable;

    public CitiesTable getCitiesTable() {
        return citiesTable;
    }

    public void setCitiesTable(CitiesTable citiesTable) {
        this.citiesTable = citiesTable;
    }
    //   private String 经纬度




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAttractionsTableId() {
        return AttractionsTableId;
    }

    public void setAttractionsTableId(int attractionsTableId) {
        AttractionsTableId = attractionsTableId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
