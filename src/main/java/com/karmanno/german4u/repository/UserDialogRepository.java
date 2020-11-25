package com.karmanno.german4u.repository;

import com.karmanno.german4u.model.UserDialog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDialogRepository extends MongoRepository<UserDialog, String> {
    boolean existsByUserId(String userId);
}
