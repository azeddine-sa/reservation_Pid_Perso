package be.iccbxl.pid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="show_id", nullable = false)
    private Show show;

    @ManyToOne
    @JoinColumn(name="location_id", nullable = false)
    private Location location;

    private Date when;

    protected Representation(){}

    public Representation(Show show, Date when, Location location){
        this.show = show;
        this.when = when;
        this.location = location;
    }

    public Date getWhen() {
        return when;
    }
    public void setWhen(Date when) {
        this.when = when;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
