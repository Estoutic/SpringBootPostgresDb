package com.example.estoutic.service;

import com.example.estoutic.controller.models.BuildProjectSaveRequest;
import com.example.estoutic.controller.models.PhoneNumberSaveRequest;
import com.example.estoutic.controller.models.UsernameSaveRequest;
import com.example.estoutic.database.models.BuildAddressEntity;
import com.example.estoutic.database.models.BuildProjectEntity;
import com.example.estoutic.database.models.PhoneNumberEntity;
import com.example.estoutic.database.models.UserNameEntity;
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

        UserNameEntity userNameData = mapper.map(usernameSaveRequest, UserNameEntity.class);

        for (PhoneNumberSaveRequest phoneNumberEntity : usernameSaveRequest.getPhones()){
            PhoneNumberEntity phoneNumberData = mapper.map(phoneNumberEntity, PhoneNumberEntity.class);
            userNameData.addPhone(phoneNumberData);
        }
        userDataToSaveRepository.save(userNameData);
        return userNameData.getId();
    }

    public UserNameEntity getUserById(String id) throws Exception {
        Optional<UserNameEntity> fromDb = userDataToSaveRepository.findOptionalById(id);
        return fromDb.orElseThrow(Exception::new);
    }

    public String saveBuildProjectData(BuildProjectSaveRequest buildProjectSaveRequest) {

        BuildProjectEntity buildProjectData = mapper.map(buildProjectSaveRequest, BuildProjectEntity.class);
        BuildAddressEntity buildAddressEntity = mapper.map(buildProjectSaveRequest.getAddress(), BuildAddressEntity.class);
        buildAddressEntity.setAddress(buildProjectSaveRequest.getAddress());
        buildProjectData.addAddress(buildAddressEntity);
        buildProjectSaveDataRepository.save(buildProjectData);
        return buildProjectData.getId();
    }

//    public String savePhoneNumberData(PhoneNumberSaveRequest phoneNumberSaveRequest) {
//
//        PhoneNumberSaveData phoneNumberSaveData = mapper.map(phoneNumberSaveRequest, PhoneNumberSaveData.class);
//        System.out.println(phoneNumberSaveRequest.getPhone());
//
//        for (PhoneNumberSaveData phoneNumberSaveData1: .getAdditionals()){
//            AdditionalEntity additionalEntity = mapper.map(additional, AdditionalEntity.class);
//            dataToSave.addAdditional(additionalEntity);
//        }
//
//        dataToSaveRepository.save(dataToSave);
//        phoneNumberSaveDataRepository.save(phoneNumberSaveData);
//        return phoneNumberSaveData.getId();
//    }
    public BuildProjectEntity getBuildProjectById(String id) throws Exception {
        Optional<BuildProjectEntity> buildProjectFromDb = buildProjectSaveDataRepository.findOptionalById(id);
        return buildProjectFromDb.orElseThrow(Exception::new);
    }
    public BuildAddressEntity getBuildAddressById(String id) throws Exception {
        Optional<BuildAddressEntity> buildAddressSveData = buildAddressSaveDataRepository.findOptionalById(id);
        return buildAddressSveData.orElseThrow(Exception::new);
    }
    public PhoneNumberEntity getPhoneById(String id) throws Exception{
        Optional<PhoneNumberEntity> phoneNumberSaveData = phoneNumberSaveDataRepository.findOptionalById(id);
        return phoneNumberSaveData.orElseThrow(Exception::new);
    }
}