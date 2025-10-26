package org.acme.controller;

import org.acme.models.LoginRequestDto;
import org.acme.service.AuthService;
import org.jboss.resteasy.reactive.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
@Controller
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> login(LoginRequestDto loginRequestDto){
        return authService.aithenticateUser(loginRequestDto);
    }
}
