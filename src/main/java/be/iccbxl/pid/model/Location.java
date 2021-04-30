package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.slugify.Slugify;

@Entity
@Table(name="locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String slug;

    @ManyToOne
    @JoinColumn(name="locality_id", nullable = false)
    private Locality locality;

    // @OneToMany(targetEntity=Locality.class, mappedBy="location", cascade = CascadeType.ALL)
    // private List<Representation> representations = new ArrayList<>();


    private String designation;
    private String address;
    private String website;
    private String phone;

    @OneToMany
    private List<Show> shows = new ArrayList<>();

    protected Location(){}

    public Location(String slug, Locality locality, String designation, String address, String website, String phone){
        Slugify slg = new Slugify();
        
        this.slug = slg.slugify(designation);
        
        this.locality = locality;
        this.designation = designation;
        this.address = address;
        this.website = website;
        this.phone = phone;
    }

    public String getSlug() {
        return slug;
    }
    private void setSlug(String slug) {
        this.slug = slug;
    }

    public Locality getLocality() {
        return locality;
    }
    public void setLocality(Locality locality) {
        this.locality.removeLocation(this);
        this.locality = locality; 
        this.locality.addLocation(this);
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;

        Slugify slg = new Slugify();

        this.setSlug(slg.slugify(designation));
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	public Location addShow(Show show) {
		if(!this.shows.contains(show)) {
			this.shows.add(show);
			show.setLocation(this);
		}
		
		return this;
	}
	
	public Location removeShow(Show show) {
		if(this.shows.contains(show)) {
			this.shows.remove(show);
			if(show.getLocation().equals(this)) {
				show.setLocation(null);
			}
		}
		
		return this;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", slug=" + slug + ", designation=" + designation 
			+ ", address=" + address	+ ", locality=" + locality + ", website=" 
			+ website + ", phone=" + phone + ", shows=" + shows.size() + "]";
	}   
}
