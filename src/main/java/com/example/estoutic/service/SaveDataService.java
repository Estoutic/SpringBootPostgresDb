package com.example.estoutic.service;

import com.example.estoutic.controllers.models.*;
import com.example.estoutic.database.models.*;
import com.example.estoutic.database.repositories.*;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
public class SaveDataService {

    private final UserNameSaveDataRepository userDataToSaveRepository;
    private final PhoneNumberSaveDataRepository phoneNumberSaveDataRepository;

    public SaveDataService(UserNameSaveDataRepository userDataToSaveRepository, ModelMapper mapper, BuildProjectSaveDataRepository buildProjectSaveDataRepository, PhoneNumberSaveDataRepository phoneNumberSaveData, BuildAddressSaveDataRepository buildAddressSaveDataRepository, RegistrationRepository registrationRepository) {
        this.userDataToSaveRepository = userDataToSaveRepository;
        this.phoneNumberSaveDataRepository = phoneNumberSaveData;
    }

    public UserNameEntity getUserById(String id) throws Exception {
        Optional<UserNameEntity> fromDb = userDataToSaveRepository.findOptionalById(id);
        return fromDb.orElseThrow(Exception::new);
    }

    public PhoneNumberEntity getPhoneById(String id) throws Exception{
        Optional<PhoneNumberEntity> phoneNumberSaveData = phoneNumberSaveDataRepository.findOptionalById(id);
        return phoneNumberSaveData.orElseThrow(Exception::new);
    }
}