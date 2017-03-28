package br.edu.ufcg.computacao.si1.model.controllers;

import br.edu.ufcg.computacao.si1.model.factories.UserFactory;
import br.edu.ufcg.computacao.si1.model.forms.UserForm;
import br.edu.ufcg.computacao.si1.model.services.UserService;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by manoel on 16/03/17.
 */
@RestController
@RequestMapping("/user/")
public class SignUpController {

    @Autowired
    private UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addNewUser(@RequestBody UserForm userForm) {
        System.out.println("Creating user " + userForm.getName());

//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult);
//            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
//        }else
        if (userService.isEmailExist(userForm.getEmail())) {
            System.out.println("User " + userForm.getName() + " already exist.");

            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        User user = UserFactory.createNewUser(userForm);
        userService.add(user);
        System.out.println("user " + userForm.getName() + " created successfully.");
        System.out.println(userService.getAll());


        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();

        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }




    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching user with id " + id);
        User user = userService.getById(id);

        if (user == null) {
            System.out.println("User with id " + id + " not found.");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }




}
