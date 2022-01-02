package traveller.com.travelplanner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "visitItem")
public class VisitItem implements Serializable {
    private static final long serialVersionUID = -2455760938054036364L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int visitItemId;

    private String date;
    // 这里是做和attraction的一对一关系
    @OneToMany
    private List<Attraction> attractionList;

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionsTableList(List<Attraction> attractionsTableList) {
        this.attractionList = attractionsTableList;
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
    private VisitPlan visitPlan;

    public VisitPlan getVisitPlan() {
        return visitPlan;
    }

    public void setVisitPlan(VisitPlan visitPlanTable) {
        this.visitPlan = visitPlan;
    }
}
