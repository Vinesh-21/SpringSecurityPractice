package com.SecurityDemo.SpringSecurity.Repository;

import com.SecurityDemo.SpringSecurity.Entity.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Roles, String> {

    Roles findByName(String name);
}
