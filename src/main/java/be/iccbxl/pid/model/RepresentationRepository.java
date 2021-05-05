package be.iccbxl.pid.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepresentationRepository extends CrudRepository<Representation,Long> {
    Representation findById(long id);

    List<Representation> findByLocation(Location location);
    List<Representation> findByShow(Show show);
    List<Representation> findByDate(Date when);
}
