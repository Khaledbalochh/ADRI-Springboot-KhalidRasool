package com.adri.AdriInternship_KhalidRasool;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
   
    @GetMapping("/hellomessage")
    public String HelloWorld(){
        return "Hello User!";
        }

        @Autowired
        private UserService service;
        @GetMapping("/all")
        public List<User> list(){
            return service.listAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> get(@PathVariable Integer id) {
   
        User user = service.get(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
        
}



        @PostMapping(path="/add") 
        public @ResponseBody User addNewUser (@RequestParam String name
              , @RequestParam String email,@RequestParam String information) {
            
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            n.setInformation(information);
            service.save(n);;
            return n;
          }   
}
