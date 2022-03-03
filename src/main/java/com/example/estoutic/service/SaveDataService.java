package com.example.estoutic.service;

import com.example.estoutic.controller.models.SaveRequest;
import com.example.estoutic.database.models.SaveData;
import com.example.estoutic.database.repositories.SaveDataRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class SaveDataService {

    private final SaveDataRepository dataToSaveRepository;
    private final ModelMapper mapper;

    public SaveDataService(SaveDataRepository dataToSaveRepository, ModelMapper mapper) {
        this.dataToSaveRepository = dataToSaveRepository;
        this.mapper = mapper;
    }

    public String saveData(SaveRequest saveRequest) {

        SaveData dataToSave = mapper.map(saveRequest, SaveData.class);

//        for (AdditionalRequest additional: saveRequest.getAdditionals()){
//            AdditionalEntity additionalEntity = mapper.map(additional, AdditionalEntity.class);
//            dataToSave.addAdditional(additionalEntity);
//        }
        dataToSaveRepository.save(dataToSave);
        return dataToSave.getId();
    }

//
}