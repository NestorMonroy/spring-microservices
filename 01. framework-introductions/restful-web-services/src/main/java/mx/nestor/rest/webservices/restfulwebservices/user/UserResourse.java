package mx.nestor.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourse {

    private UserDaoService service;

    public UserResourse(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUser(){
        return service.findAll();
    }


    //http://localhost:8080/users
    //EntityModel
    //WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id:" + id);
            EntityModel<User> entityModel = EntityModel.of(user);
            WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUser());
            entityModel.add(link.withRel("all-users"));
            return entityModel;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){

        User savedUser = service.save(user);

        // /user/4 => /users/{1},
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

         ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

}
