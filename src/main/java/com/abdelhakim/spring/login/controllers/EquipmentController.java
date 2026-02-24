package com.abdelhakim.spring.login.controllers;

import com.abdelhakim.spring.login.models.Booking;
import com.abdelhakim.spring.login.models.Equipment;
import com.abdelhakim.spring.login.repository.BookingRepository;
import com.abdelhakim.spring.login.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    EquipmentRepository equipmentRepository;
    BookingRepository bookingRepository;

    // 1. Get all machines (Public - 9bel login)
    @GetMapping("/all")
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    // 2. Add machine (Admin only)
    @PostMapping("/add")
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);

    }

    // 3. edit machine (Admin only)
    @PutMapping("/update/{id}")
    public Equipment updateEquipment(@PathVariable String id, @RequestBody Equipment equipmentDetails) {
        // 1. كنجبدو الماكينة اللي كاينة أصلاً في الداتابيز
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with id: " + id));

        // 2. كنحدثو البيانات ديالها (هادشي اللي درتي صحيح)
        equipment.setName(equipmentDetails.getName());
        equipment.setCategory(equipmentDetails.getCategory());
        equipment.setPrice(equipmentDetails.getPrice());
        equipment.setImage(equipmentDetails.getImage());
        equipment.setDescription(equipmentDetails.getDescription());
        equipment.setSpecs(equipmentDetails.getSpecs());
        equipment.setStatus(equipmentDetails.getStatus());

        // 3. ⚠️ الضربة القاضية: كنحفظو "equipment" (اللي ديجا عندو ID ديال المونغو)
        return equipmentRepository.save(equipment);
    }



    // 3. Delete machine (Admin only)
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEquipment(@PathVariable String id) {
        equipmentRepository.deleteById(id);
        return "Equipment deleted successfully!";
    }
}