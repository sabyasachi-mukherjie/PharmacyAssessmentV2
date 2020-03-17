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

    /* Update the incoming student request to H2 database */
    @PutMapping(value = "/user/save")
    public Object update(final @RequestBody @Valid User user) {
        log.info("Updating student details in the database.");
        return service.update(user);
    }

   /* Get all the student records saved so far in H2 database */
    @GetMapping(value = "/user/list", produces = "application/vnd.jcg.api.v1+json")
	public List<UserEntity> getAll(@RequestParam(value = "columns", required = false) String columns,
								   @RequestParam(value = "number", required = false) String records,
								   @RequestParam(value = "page", required = false) String pageNo) {
		log.info("You have requested to see the following fields: {} ", columns);
		log.info("Getting user details from the database for page no {} with total record numbers of {} in each page",
				pageNo, records);
		return service.getAll(columns, records, pageNo);
	}

}
