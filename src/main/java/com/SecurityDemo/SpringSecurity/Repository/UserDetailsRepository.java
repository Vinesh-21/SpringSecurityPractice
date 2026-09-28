package com.SecurityDemo.SpringSecurity.Repository;


import com.SecurityDemo.SpringSecurity.Entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends MongoRepository<Users,String> {

    public Users findByUsername(String username);


}
