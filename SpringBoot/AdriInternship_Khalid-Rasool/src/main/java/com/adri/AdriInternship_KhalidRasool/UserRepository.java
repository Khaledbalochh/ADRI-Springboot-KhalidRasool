package com.adri.AdriInternship_KhalidRasool;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//the repository class for entity user
@Repository
    public interface UserRepository extends CrudRepository<User, Integer> {
        List<User> findAll();
       List<User> findByusernameIgnoreCase(String username);
    }
