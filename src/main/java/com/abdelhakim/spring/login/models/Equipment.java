package com.abdelhakim.spring.login.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Document(collection = "equipments")
public class Equipment {
    @Id
    private String id;
    private String name;
    private String category;
    private Double price;
    private String image;
    private String description;
    private Map<String, String> specs; // باش تخزن (engine, weight, etc.)
    private String status = "Available"; // الحالة الافتراضية

    // Constructors, Getters, Setters (Ghia n9adhom b Alt+Enter f IntelliJ)
    public Equipment() {}

    public Equipment(String name, String category, Double price, String image, String description, Map<String, String> specs) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
        this.description = description;
        this.specs = specs;
    }

    // Getters and Setters ...
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Map<String, String> getSpecs() { return specs; }
    public void setSpecs(Map<String, String> specs) { this.specs = specs; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void setId(String id) {

    }
}