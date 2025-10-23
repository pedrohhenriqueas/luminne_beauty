package org.acme.controller;

import org.acme.models.CreateUserDto;
import org.acme.service.UserService;
import org.jboss.resteasy.reactive.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> create(CreateUserDto newUser) {
        userService.create(newUser);
        return RestResponse.ok(newUser);
    }
}