package com.example.estoutic.service;

import com.example.estoutic.controller.models.*;
import com.example.estoutic.database.models.*;
import com.example.estoutic.database.repositories.*;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaveDataService {

    private ArrayList<RegistrationEntity> registrationEntities;
    private final UserNameSaveDataRepository userDataToSaveRepository;
    private final BuildProjectSaveDataRepository buildProjectSaveDataRepository;
    private final PhoneNumberSaveDataRepository phoneNumberSaveDataRepository;
    private final BuildAddressSaveDataRepository buildAddressSaveDataRepository;
    private final RegistrationRepository registrationRepository;
    private final ModelMapper mapper;

    public SaveDataService(UserNameSaveDataRepository userDataToSaveRepository, ModelMapper mapper, BuildProjectSaveDataRepository buildProjectSaveDataRepository, PhoneNumberSaveDataRepository phoneNumberSaveData, BuildAddressSaveDataRepository buildAddressSaveDataRepository, RegistrationRepository registrationRepository) {
        this.userDataToSaveRepository = userDataToSaveRepository;
        this.buildAddressSaveDataRepository = buildAddressSaveDataRepository;
        this.buildProjectSaveDataRepository = buildProjectSaveDataRepository;
        this.phoneNumberSaveDataRepository = phoneNumberSaveData;
        this.registrationRepository = registrationRepository;
        this.mapper = mapper;
        this.registrationEntities = new ArrayList<>();
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
    public void registrationUserProject(RegistrationRequest registrationRequest){

        for(ProjectUserRequest projectUserRequest:registrationRequest.getProjects()){

            BuildProjectEntity project = mapper.map(projectUserRequest.getProject(), BuildProjectEntity.class);
            project.setProjectName(projectUserRequest.getProject());

            for(String name: projectUserRequest.getUsers()){

                RegistrationEntity registration = new RegistrationEntity();
                UserNameEntity user = mapper.map(name, UserNameEntity.class);
                user.setName(name);
                registration.addBuildProject(user,project);
                userDataToSaveRepository.save(user);
                buildProjectSaveDataRepository.save(project);
                registrationRepository.save(registration);
            }
        }
//        registrationRepository.saveAll(registrationEntities);

    }
}