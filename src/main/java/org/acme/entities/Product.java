package org.acme.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private Double price;
    private String imagePath;
    private Double reviews;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public Double getReviews() {
        return reviews;
    }
    public void setReviews(Double reviews) {
        this.reviews = reviews;
    }
}
