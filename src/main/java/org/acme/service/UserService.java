package org.acme.service;

import java.util.List;
import java.util.Optional;

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
        newUser.setEmail(user.getEmail());
        newUser.setCart(user.getCart());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return newUser;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User update(CreateUserDto createUserDto){
        User user = findById(createUserDto.getId());
        user.setCart(createUserDto.getCart());
        user.setEmail(createUserDto.getEmail());
        user.setName(createUserDto.getName());
        user.setPassword(createUserDto.getPassword());
        userRepository.save(user);
        return user;
    }
}
