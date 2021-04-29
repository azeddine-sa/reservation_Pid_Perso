package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "localities")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postalCode;
    private String locality;

    @OneToMany(targetEntity=Location.class, mappedBy="locality", cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    protected Locality(){}

    public Locality(String postalCode, String locality){
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public List<Location> getLocations() {
        return locations;
    }
    public Locality addLocation(Location location){
        if(!this.locations.contains(location)){
            this.locations.add(location);
            location.setLocality(this);
        }
        return this;
    }
    public Locality removeLocation(Location location){
        if(this.locations.contains(location)){
            this.locations.remove(location);
                if(location.getLocality().equals(this)){
                    location.setLocality(null);
                }
        }

        return this;
    }

    @Override
    public String toString() {
        return postalCode + " " + locality;
    }
}
