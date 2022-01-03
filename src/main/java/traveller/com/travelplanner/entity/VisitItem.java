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
    // 这里是做和attraction的多对一关系
    @ManyToOne
    private Attraction attraction;

    public int getVisitItemId() {
        return visitItemId;
    }

    public void setVisitItemId(int visitItemId) {
        this.visitItemId = visitItemId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
    public Attraction getAttraction() {
        return attraction;
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

    public void setVisitPlan(VisitPlan visitPlan) {
        this.visitPlan = visitPlan;
    }
}
