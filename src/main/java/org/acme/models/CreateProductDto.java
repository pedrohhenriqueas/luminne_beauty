package org.acme.models;

public class CreateProductDto {
    private int id;
    private String name;
    private String description;
    private Double price;
    private String path;
    private double reviews;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public double getReviews() {
        return reviews;
    }
    public void setReviews(double reviews) {
        this.reviews = reviews;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
