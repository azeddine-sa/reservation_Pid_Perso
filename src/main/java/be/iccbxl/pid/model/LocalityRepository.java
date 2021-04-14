package be.iccbxl.pid.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LocalityRepository extends CrudRepository <Locality, Long> {
    List<Locality> findByPostalCode(String postalCode);
    
    Locality findById(long id);
}
