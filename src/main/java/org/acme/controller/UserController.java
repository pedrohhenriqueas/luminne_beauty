package org.acme.controller;

import java.util.List;

import org.acme.entities.Product;
import org.acme.entities.User;
import org.acme.models.CreateUserDto;
import org.acme.service.UserService;
import org.jboss.resteasy.reactive.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Object> findAll(){
        List<User> user = userService.findAll();
        return RestResponse.ok(user);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> update(User user){
        userService.update(user);
        User updatedUser = userService.findById(user.getId());
        return RestResponse.ok(updatedUser);
    }

    @GET
    @Path("/cart")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> getUserCart(@QueryParam("userId") int userId){
        List<Product> products = userService.getUserCart(userId);
        return RestResponse.ok(products);
    }
    
}