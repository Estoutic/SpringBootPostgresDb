package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.BuildAddressSaveData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildAddressSaveDataRepository extends JpaRepository<BuildAddressSaveData, String> {
    Optional<BuildAddressSaveData> findOptionalById(String id);
}
