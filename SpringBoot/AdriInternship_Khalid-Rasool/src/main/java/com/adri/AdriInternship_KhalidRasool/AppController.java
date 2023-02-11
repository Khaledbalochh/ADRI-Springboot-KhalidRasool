package com.adri.AdriInternship_KhalidRasool;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
        //question3.1
        //Displays a Hello Message
        
         @GetMapping("/hellomessage")
         public String HelloWorld(){
                try {
                        return "Hello User!";
                      }
                      catch(Exception e) {
                        return "An Error Occured, this is not a welcoming message!";
                      }
                
        }
        //question3.2
        //Shows a specific user by name
        //http://localhost:8080/app/name/salman
        @GetMapping(value="/name/{name}",produces = "application/json")
        public ResponseEntity<List<User>> findUser(@PathVariable String name){
           return new ResponseEntity<List<User>>(service.findUser(name), HttpStatus.OK);
        }
        //question3.3
        // add a user to the database as a json and return saved user as json
        //http://localhost:8080/app/add, In Postman>> Select POST>> under body, choose raw>> select JSON and paste JSON entity
         @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
        public ResponseEntity<User> create(@RequestBody User newUser) {
                User user = service.save(newUser);
                return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        
        //IGNOREvv
        //Shows all users as a JSON String
        @Autowired
        private UserService service;
        
        @GetMapping("/all")
        public List<User> list(){
            return service.listAll();
        }

        //Shows a specific user by id
        //http://localhost:8080/app/id/1
        @GetMapping(value="/id/{id}",produces = "application/json")
        public ResponseEntity<User> get(@PathVariable Integer id) {
   
        User user = service.get(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
        
}

/*
@PostMapping("/find")
public ResponseEntity<User> user(@RequestParam String user_name) {
        List allUsers = service.listAll();
        for(int i=0;i<allUsers.size();i++){
        User user = service.get(i);
        if (user.getName()==user_name){
        return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        }
        
        
}

 @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        // make sure to check whether the new person does not already exist
        
        return new ResponseEntity<User>(service.save(user), HttpStatus.OK);
    }
//Adds a user to the database workingggggg
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
        
          */ 
}
