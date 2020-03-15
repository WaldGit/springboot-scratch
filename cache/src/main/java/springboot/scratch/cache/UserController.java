package springboot.scratch.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    UserService userService;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @PathVariable String username) {

        return new ResponseEntity<>(userService.updateUserById(id, username), HttpStatus.OK);
    }

    @GetMapping(path = "/users/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {

        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/users/initialize", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> initialize() {

        userService.initialize();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/users/clear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> clear() {

        userService.clear();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
