package org.acme.service;

import org.acme.entities.User;
import org.acme.models.LoginRequestDto;
import org.acme.repository.UserRepository;
import org.jboss.resteasy.reactive.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.ws.rs.core.Response;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    
    public RestResponse<Object> aithenticateUser(LoginRequestDto loginRequestDto){
        User user = userRepository.findByEmail(loginRequestDto.getEmail());
        if(user.getPassword().equals(loginRequestDto.getPassword())){
            return RestResponse.ok("Usuário autorizado");
        } else {
            return RestResponse.status(Response.Status.UNAUTHORIZED, "Acesso Negado");
        }
    }
}
