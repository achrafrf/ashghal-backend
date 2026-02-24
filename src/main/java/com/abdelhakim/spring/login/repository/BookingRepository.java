package com.abdelhakim.spring.login.repository;
import com.abdelhakim.spring.login.repository.BookingRepository;

import com.abdelhakim.spring.login.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByUserId(String userId); // باش نجبدو للكليان التاريخ ديالو
}