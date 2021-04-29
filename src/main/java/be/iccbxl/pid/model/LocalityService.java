package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getAllLocalities(){
        List<Locality> localities = new ArrayList<>();
        
        localityRepository.findAll().forEach(localities::add);

        return localities;
    }

    public Locality getLocality(String id){
        int indice = Integer.parseInt(id);

        return localityRepository.findById(indice);
    }

    public void addLocality(Locality locality){
        localityRepository.save(locality);
    }

    public void updateLocality(String id, Locality locality){
        localityRepository.save(locality);
    }  
    
    public void deleteLocality(String id){
        Long indice = (long) Integer.parseInt(id);

        localityRepository.deleteById(indice);
    }
}
