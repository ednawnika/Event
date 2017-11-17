package com.project.Event.repositories;

import com.project.Event.models.Role;
import java.util.List;
import javax.persistence.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface RoleRepository extends CrudRepository<Role,Long>{
    List<Role> findAll();
    List<Role> findByName(String name);
    
    Role findByname(String name);

}
