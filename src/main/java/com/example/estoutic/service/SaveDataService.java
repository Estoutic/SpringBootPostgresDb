package com.example.estoutic.service;

import com.example.estoutic.controller.models.BuildAddressSaveRequest;
import com.example.estoutic.controller.models.BuildProjectSaveRequest;
import com.example.estoutic.controller.models.TelephoneNumberSaveRequest;
import com.example.estoutic.controller.models.UsernameSaveRequest;
import com.example.estoutic.database.models.BuildAddressSaveData;
import com.example.estoutic.database.models.BuildProjectSaveData;
import com.example.estoutic.database.models.PhoneNumberSaveData;
import com.example.estoutic.database.models.UserNameSaveData;
import com.example.estoutic.database.repositories.BuildAddressSaveDataRepository;
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
    private final BuildAddressSaveDataRepository buildAddressSaveDataRepository;
    private final ModelMapper mapper;

    public SaveDataService(UserNameSaveDataRepository userDataToSaveRepository, ModelMapper mapper, BuildProjectSaveDataRepository buildProjectSaveDataRepository, PhoneNumberSaveDataRepository phoneNumberSaveData, BuildAddressSaveDataRepository buildAddressSaveDataRepository) {
        this.userDataToSaveRepository = userDataToSaveRepository;
        this.buildAddressSaveDataRepository = buildAddressSaveDataRepository;
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

        PhoneNumberSaveData phoneNumberSaveData = mapper.map(telephoneNumberSaveRequest, PhoneNumberSaveData.class);
        System.out.println(telephoneNumberSaveRequest.getTelephone());

        phoneNumberSaveDataRepository.save(phoneNumberSaveData);
        return phoneNumberSaveData.getId();
    }
    public BuildProjectSaveData getBuildProjectById(String id) throws Exception {
        Optional<BuildProjectSaveData> buildProjectFromDb = buildProjectSaveDataRepository.findOptionalById(id);
        return buildProjectFromDb.orElseThrow(Exception::new);
    }

    public String saveBuildAddressData(BuildAddressSaveRequest buildAddressSaveRequest) {

        BuildAddressSaveData buildAddressSaveData = mapper.map(buildAddressSaveRequest, BuildAddressSaveData.class);
        System.out.println(buildAddressSaveRequest.getAddress());

        buildAddressSaveDataRepository.save(buildAddressSaveData);
        return buildAddressSaveData.getId();
    }
    public BuildAddressSaveData getBuildAddressById(String id) throws Exception {
        Optional<BuildAddressSaveData> buildAddressSveData = buildAddressSaveDataRepository.findOptionalById(id);
        return buildAddressSveData.orElseThrow(Exception::new);
    }
    public PhoneNumberSaveData getPhoneById(String id) throws Exception{
        Optional<PhoneNumberSaveData> phoneNumberSaveData = phoneNumberSaveDataRepository.findOptionalById(id);
        return phoneNumberSaveData.orElseThrow(Exception::new);
    }
}