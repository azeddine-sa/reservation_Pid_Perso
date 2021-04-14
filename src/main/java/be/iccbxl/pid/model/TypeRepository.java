package be.iccbxl.pid.model;

import org.springframework.data.repository.CrudRepository;


public interface TypeRepository extends CrudRepository<Type, Long>{
    Type findById(long id);
}
