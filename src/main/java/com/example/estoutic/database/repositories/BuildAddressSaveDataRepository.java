package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.BuildAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildAddressSaveDataRepository extends JpaRepository<BuildAddressEntity, String> {
    Optional<BuildAddressEntity> findOptionalById(String id);
}
