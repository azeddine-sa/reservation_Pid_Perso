package be.iccbxl.pid.model;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findById(long id);   
    Role findByRole(String role);
}
