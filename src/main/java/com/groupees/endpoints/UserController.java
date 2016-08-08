package com.groupees.endpoints;

import com.groupees.models.User;
import com.groupees.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.groupees.endpoints.UserController.BASE_URL;

@RestController
@RequestMapping(value = BASE_URL, produces = "application/json")
public class UserController {

    static final String BASE_URL = "/api/v1/users";

    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> findByFirstName(@RequestParam String firstName) {
        User queriedUser = repository.findByFirstName(firstName);

        return new ResponseEntity<>(queriedUser, HttpStatus.OK);
    }
}
