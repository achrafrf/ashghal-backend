package com.abdelhakim.spring.login.models;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "refreshtoken") // Blast @Entity
public class RefreshToken {
    @Id
    private String id; // String ⚠️

    @DBRef // Blast @OneToOne dial MySQL
    private User user;

    private String token;
    private Instant expiryDate;

    public RefreshToken() {}

    // Zid ga3 l-Getters o l-Setters hna...
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Instant getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Instant expiryDate) { this.expiryDate = expiryDate; }
}