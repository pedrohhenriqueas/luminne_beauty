package org.acme.service;

import org.acme.entities.User;
import org.acme.models.CreateUserDto;
import org.acme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User create(CreateUserDto user){
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setCart(user.getCart());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return newUser;
    }
}
