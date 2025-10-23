package org.acme.models;

import java.util.List;

import org.acme.entities.Product;

public class CreateUserDto {
    
    private String name;
    private String password;
    private List<Product> cart;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Product> getCart() {
        return cart;
    }
    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
