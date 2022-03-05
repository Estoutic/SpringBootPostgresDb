package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneNumberSaveDataRepository extends JpaRepository<PhoneNumberEntity,String> {
    Optional<PhoneNumberEntity> findOptionalById(String id);
}
