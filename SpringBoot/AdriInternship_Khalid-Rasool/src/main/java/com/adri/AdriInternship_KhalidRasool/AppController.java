package com.adri.AdriInternship_KhalidRasool;







import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    /**
     * @return
     */
    @GetMapping("/hellomessage")
    public String HelloWorld(){
        return "Hello User!";
        }

        @Autowired
        //private UserRepository UserRepository;
        private UserService service;
        @GetMapping("/allusers")
        public List<User> list(){
            return service.listAll();
        }
        @GetMapping("/{id}")
public ResponseEntity<User> get(@PathVariable Integer id) {
    try {
        User user = service.get(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }      
}
@PostMapping(path="/add") 
          public @ResponseBody String addNewUser (@RequestParam String name
              , @RequestParam String email,@RequestParam String information) {
            
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            n.setInformation(information);
            service.save(n);;
            return "Saved";
          }

    /*
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
*/
         /* @GetMapping("view/{id}")
    public Optional<Customer> getCustomer(@PathVariable String user_name) {
        return UserRepository.findByName(user_name);
    }
*/
          
}
