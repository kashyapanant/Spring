package com.infinity.co.repository;

import com.infinity.co.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

    UserDetails findByName(String name);
}
