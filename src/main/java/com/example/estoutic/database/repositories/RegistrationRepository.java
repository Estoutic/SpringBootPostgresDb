package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.RegistrationEntity;
import com.example.estoutic.database.models.UserNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, String> {
    Optional<RegistrationEntity> findOptionalById(String id);
}
