package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.PhoneNumberSaveData;
import com.example.estoutic.database.models.UserNameSaveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneNumberSaveDataRepository extends JpaRepository<PhoneNumberSaveData,String> {
    Optional<UserNameSaveData> findOptionalById(String id);
}
