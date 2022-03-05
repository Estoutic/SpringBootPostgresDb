package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.UserNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserNameSaveDataRepository extends JpaRepository<UserNameEntity, String> {
    Optional<UserNameEntity> findOptionalById(String id);
}
