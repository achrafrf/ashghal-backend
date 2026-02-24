package com.abdelhakim.spring.login.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository; // ⚠️ Darouri had l-import
import com.abdelhakim.spring.login.models.RefreshToken;
import com.abdelhakim.spring.login.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends MongoRepository<RefreshToken, String> { // ⚠️ Beddel Long l String hna
    Optional<RefreshToken> findByToken(String token);

    // F MongoDB kandirou void hit delete basic
    void deleteByUser(User user);
}