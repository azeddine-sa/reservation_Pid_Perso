package be.iccbxl.pid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localities")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postalCode;
    private String locality;

    protected Locality(){};

    public Locality(String postalCode, String locality){
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public String getLocality() {
        return locality;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return postalCode + " " + locality;
    }
}
