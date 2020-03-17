package org.pharmacy.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.pharmacy.poc.model.User;
import org.pharmacy.poc.model.UserEntity;
import org.pharmacy.poc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService service;

    /* Save the incoming student request to H2 database */
    @PostMapping(value = "/user/save")
    public Object save(final @RequestBody @Valid User user) {
        log.info("Saving student details in the database.");
        return service.save(user);
    }

}
