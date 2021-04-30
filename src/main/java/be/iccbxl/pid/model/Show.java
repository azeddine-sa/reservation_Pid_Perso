package be.iccbxl.pid.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import com.github.slugify.Slugify;

@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(unique=true)
	private String slug;

	private String title;
	private String description;

	@Column(name="poster_url")
	private String posterUrl;
	
	/**
	 * Lieu de création du spectacle
	 */
	@ManyToOne
	@JoinColumn(name="location_id", nullable=false)
	private Location location;
	
	private boolean bookable;
	private double price;
	
	/**
	 * Date de création du spectacle
	 */
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	/**
	 * Date de modification du spectacle
	 */
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

	public Show() { }
	
	public Show(String title, String description, String posterUrl, Location location, boolean bookable,
			double price) {
		Slugify slg = new Slugify();
		
		this.slug = slg.slugify(title);
		this.title = title;
		this.description = description;
		this.posterUrl = posterUrl;
		this.location = location;
		this.bookable = bookable;
		this.price = price;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = null;
	}


	public String getSlug() {
		return slug;
	}

	private void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		
		Slugify slg = new Slugify();
		
		this.setSlug(slg.slugify(title));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location.removeShow(this);	//déménager de l’ancien lieu
		this.location = location;
		this.location.addShow(this);		//emménager dans le nouveau lieu
	}

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", slug=" + slug + ", title=" + title 
			+ ", description=" + description + ", posterUrl=" + posterUrl + ", location=" 
			+ location + ", bookable=" + bookable + ", price=" + price
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}