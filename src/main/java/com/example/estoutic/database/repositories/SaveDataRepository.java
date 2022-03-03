package com.example.estoutic.database.repositories;

import com.example.estoutic.database.models.SaveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveDataRepository extends JpaRepository<SaveData, String> {

}
