package com.example.travelplandemo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plannedTable")
public class VisitItemTable implements Serializable {
    private static final long serialVersionUID = -2455760938054036364L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int visitItemId;

    private String date;
    // 这里是做和attraction的一对一关系
    @OneToMany
    private List<AttractionsTable> attractionsTableList;

    public List<AttractionsTable> getAttractionsTableList() {
        return attractionsTableList;
    }

    public void setAttractionsTableList(List<AttractionsTable> attractionsTableList) {
        this.attractionsTableList = attractionsTableList;
    }

    public int getVisitItemId() {
        return visitItemId;
    }

    public void setVisitItemId(int visitItemId) {
        this.visitItemId = visitItemId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
    //这里是做和visitPlan的一对多关系
    @ManyToOne
    @JsonIgnore
    private VisitPlanTable visitPlanTable;

    public VisitPlanTable getVisitPlanTable() {
        return visitPlanTable;
    }

    public void setVisitPlanTable(VisitPlanTable visitPlanTable) {
        this.visitPlanTable = visitPlanTable;
    }
}
