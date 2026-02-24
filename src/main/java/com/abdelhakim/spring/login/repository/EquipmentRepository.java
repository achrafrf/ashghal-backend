package com.abdelhakim.spring.login.repository;

import com.abdelhakim.spring.login.models.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EquipmentRepository extends MongoRepository<Equipment, String> {
    List<Equipment> findByCategory(String category);
}