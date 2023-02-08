package com.adri.AdriInternship_KhalidRasool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    /**
     * @return
     */
    @GetMapping("/hellomessage")
    public String HelloWorld(){
        return "Hello User!";
        }

        @Autowired
        private UserRepository UserRepository;
        
        
            @GetMapping("/all")
            public @ResponseBody Iterable<User> getAllUsers() {
              return UserRepository.findAll();
            }
        
            @PostMapping(path="/add") 
          public @ResponseBody String addNewUser (@RequestParam String name
              , @RequestParam String email,@RequestParam String information) {
            
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            n.setInformation(information);
            UserRepository.save(n);
            return "Saved";
          }
}
