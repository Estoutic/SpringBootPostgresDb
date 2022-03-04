package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.BuildProjectSaveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuildProjectSaveDataRepository extends JpaRepository<BuildProjectSaveData, String>  {
    Optional<BuildProjectSaveData> findOptionalById(String id);
}
