package org.acme.models;

import java.util.List;

import org.acme.entities.Product;

public class CreateUserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Product> cart;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
