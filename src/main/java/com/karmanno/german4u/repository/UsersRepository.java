package com.karmanno.german4u.repository;

import com.karmanno.german4u.model.TelegramUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<TelegramUser, String> {
    boolean existsByUsername(String username);
    Optional<TelegramUser> findByUsername(String username);
}
