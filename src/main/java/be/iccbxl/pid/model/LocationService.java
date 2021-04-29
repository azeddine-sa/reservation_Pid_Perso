package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(){
        List<Location> locations = new ArrayList<>();

        locationRepository.findAll().forEach(locations::add);

        return locations;
    }

    public Location getLocation(String id){
        int indice = Integer.parseInt(id);

        return locationRepository.findById(indice);
    }

    public void addLocation(Location location){
        locationRepository.save(location);
    }

    public void updateLocation(String id, Location location){
        locationRepository.save(location);
    }

    public void deleteLocation(String id){
        Long indice = (long) Integer.parseInt(id);

        locationRepository.deleteById(indice);
    }

    public List<Location> getFromLocality(Locality locality) {
		return locationRepository.findByLocality(locality);
	}

    
}
