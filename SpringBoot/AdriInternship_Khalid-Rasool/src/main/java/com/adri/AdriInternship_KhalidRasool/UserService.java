package com.adri.AdriInternship_KhalidRasool;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//the srevices class for user repository
@Service
@Transactional
public class UserService {
    
 
        @Autowired
        private UserRepository repo;
         
        public List<User> listAll() {
            return repo.findAll();
        }
         
        public User save(User user) {
            return repo.save(user);
        }
         
        public User get(Integer id) {
            return repo.findById(id).get();
        }
        public List<User> findUser(String username) {
            return repo.findByusernameIgnoreCase(username);
        }
        
}
