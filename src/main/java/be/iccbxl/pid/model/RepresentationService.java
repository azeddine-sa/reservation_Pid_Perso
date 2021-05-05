package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentationService {
    @Autowired
    private RepresentationRepository repository;

    public List<Representation> getAllRepresentations(){
        List<Representation> representations = new ArrayList<>();

        repository.findAll().forEach(representations::add);

        return representations;
    }

    public Representation getRepresentation(String id){
        Long indice = (long) Integer.parseInt(id);
        Optional<Representation> representation = repository.findById(indice);

        return representation.isPresent() ? representation.get() : null;
    }

    public void addRepresentation(Representation representation){
        repository.save(representation);
    }

    public void updateRepresentation(String id, Representation representation){
        repository.save(representation);
    }

    public void deleteRepresentation(String id){
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }

    public List<Representation> getFromLocation(Location location) {
		return repository.findByLocation(location);
    }

    public List<Representation> getFromShow(Show show) {
		return repository.findByShow(show);
    }


}
