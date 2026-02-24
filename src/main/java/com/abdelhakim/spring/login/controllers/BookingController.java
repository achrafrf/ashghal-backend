package com.abdelhakim.spring.login.controllers;

import com.abdelhakim.spring.login.models.Booking;
import com.abdelhakim.spring.login.models.Equipment;
import com.abdelhakim.spring.login.repository.BookingRepository;
import com.abdelhakim.spring.login.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    EquipmentRepository equipmentRepository;

    // 1. كليان كيدير طلب جديد
    @PostMapping("/add")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    // 2. كليان كيشوف الطلبات ديالو بوحدو
    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable String userId) {
        return bookingRepository.findByUserId(userId);
    }

    // 3. أدمين كيشوف كاع الطلبات ديال كاع الناس
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // 4. أدمين كيوافق ولا كيرفض الطلب

    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestParam String status) {
        try {
            System.out.println("Updating Booking ID: " + id + " to status: " + status);

            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Booking not found"));

            booking.setStatus(status);
            bookingRepository.save(booking);

            if ("APPROVED".equals(status)) {
                String machineId = booking.getEquipmentId();
                System.out.println("Attempting to find machine with ID: " + machineId);

                if (machineId == null || machineId.isEmpty()) {
                    return ResponseEntity.badRequest().body("Error: This booking has NO equipmentId!");
                }

                equipmentRepository.findById(machineId).ifPresentOrElse(
                        eq -> {
                            eq.setStatus("Rented");
                            equipmentRepository.save(eq);
                            System.out.println("SUCCESS: Machine " + eq.getName() + " is now RENTED");
                        },
                        () -> {
                            System.out.println("ERROR: Machine ID " + machineId + " NOT FOUND in database!");
                        }
                );
            }

            return ResponseEntity.ok(booking);
        } catch (Exception e) {
            e.printStackTrace(); // غايطلع ليك الغلط مفصل ف IntelliJ
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
    // زيد هادي ف BookingController.java
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable String id) {
        bookingRepository.deleteById(id);
        return ResponseEntity.ok("Booking removed from history");
    }

}