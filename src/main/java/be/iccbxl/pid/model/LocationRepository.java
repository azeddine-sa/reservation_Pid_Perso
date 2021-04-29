package be.iccbxl.pid.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long>{
    Location findById(long id);

    List<Location> findByDesignation(String designation);
    List<Location> findByAddress(String address);
    List<Location> findByLocality(Locality locality);
}
