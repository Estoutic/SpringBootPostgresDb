package com.example.estoutic.service;

import com.example.estoutic.controller.models.BuildProjectSaveRequest;
import com.example.estoutic.controller.models.TelephoneNumberSaveRequest;
import com.example.estoutic.controller.models.UsernameSaveRequest;
import com.example.estoutic.database.models.BuildProjectSaveData;
import com.example.estoutic.database.models.PhoneNumberSaveData;
import com.example.estoutic.database.models.UserNameSaveData;
import com.example.estoutic.database.repositories.BuildProjectSaveDataRepository;
import com.example.estoutic.database.repositories.PhoneNumberSaveDataRepository;
import com.example.estoutic.database.repositories.UserNameSaveDataRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
public class SaveDataService {

    private final UserNameSaveDataRepository userDataToSaveRepository;
    private final BuildProjectSaveDataRepository buildProjectSaveDataRepository;
    private final PhoneNumberSaveDataRepository phoneNumberSaveDataRepository;
    private final ModelMapper mapper;

    public SaveDataService(UserNameSaveDataRepository userDataToSaveRepository, ModelMapper mapper, BuildProjectSaveDataRepository buildProjectSaveDataRepository, PhoneNumberSaveDataRepository phoneNumberSaveData) {
        this.userDataToSaveRepository = userDataToSaveRepository;
        this.buildProjectSaveDataRepository = buildProjectSaveDataRepository;
        this.phoneNumberSaveDataRepository = phoneNumberSaveData;
        this.mapper = mapper;
    }

    public String saveUserNameData(UsernameSaveRequest usernameSaveRequest) {

        UserNameSaveData dataToSave = mapper.map(usernameSaveRequest, UserNameSaveData.class);

        userDataToSaveRepository.save(dataToSave);
        return dataToSave.getId();
    }

    public UserNameSaveData getUserById(String id) throws Exception {
        Optional<UserNameSaveData> fromDb = userDataToSaveRepository.findOptionalById(id);
        return fromDb.orElseThrow(Exception::new);
    }

    public String saveBuildProjectData(BuildProjectSaveRequest buildProjectSaveRequest) {

        BuildProjectSaveData buildProjectData = mapper.map(buildProjectSaveRequest, BuildProjectSaveData.class);

        buildProjectSaveDataRepository.save(buildProjectData);
        return buildProjectData.getId();
    }

    public String savePhoneNumberData(TelephoneNumberSaveRequest telephoneNumberSaveRequest) {

        System.out.println(telephoneNumberSaveRequest.getTelephone());

        PhoneNumberSaveData phoneNumberSaveData = mapper.map(telephoneNumberSaveRequest, PhoneNumberSaveData.class);

        phoneNumberSaveDataRepository.save(phoneNumberSaveData);
        return phoneNumberSaveData.getId();
    }
}