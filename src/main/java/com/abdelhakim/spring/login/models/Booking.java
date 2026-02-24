package com.abdelhakim.spring.login.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;
    private String userId;      // شكون كرا
    private String username;    // سميتو باش تافيشيها للأدمين دغيا
    private String equipmentId; // شنو كرا
    private String equipmentName; // سمية الماكينة
    private Double totalPrice;
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED
    private LocalDateTime createdAt = LocalDateTime.now();

    public Booking() {}

    public Booking(String userId, String username, String equipmentId, String equipmentName, Double totalPrice) {
        this.userId = userId;
        this.username = username;
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters (Alt + Enter f IntelliJ)
    public String getId() { return id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }
    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}