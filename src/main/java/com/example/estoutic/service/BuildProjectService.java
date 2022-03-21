package com.example.estoutic.service;

import com.example.estoutic.controllers.models.ProjectUserRequest;
import com.example.estoutic.controllers.models.RegistrationRequest;
import com.example.estoutic.controllers.models.UserDTO;
import com.example.estoutic.database.models.*;
import com.example.estoutic.database.repositories.BuildProjectSaveDataRepository;
import com.example.estoutic.database.repositories.RegistrationRepository;
import com.example.estoutic.database.repositories.UserNameSaveDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuildProjectService {

    private final BuildProjectSaveDataRepository buildProjectSaveDataRepository;
    private final ModelMapper mapper;
    private final  UserNameSaveDataRepository userDataToSaveRepository;
    private final RegistrationRepository registrationRepository;

    public BuildProjectService(BuildProjectSaveDataRepository buildProjectSaveDataRepository, ModelMapper mapper, UserNameSaveDataRepository userDataToSaveRepository, RegistrationRepository registrationRepository) {
        this.buildProjectSaveDataRepository = buildProjectSaveDataRepository;
        this.mapper = mapper;
        this.userDataToSaveRepository = userDataToSaveRepository;
        this.registrationRepository = registrationRepository;
    }

    public BuildProjectEntity getBuildProjectById(String id) throws Exception {
        Optional<BuildProjectEntity> buildProjectFromDb = buildProjectSaveDataRepository.findOptionalById(id);
        return buildProjectFromDb.orElseThrow(Exception::new);
    }

    public void registrationUserProject(RegistrationRequest registrationRequest){

        for(ProjectUserRequest projectUserRequest:registrationRequest.getProjects()){

            BuildProjectEntity project = mapper.map(projectUserRequest.getProject(), BuildProjectEntity.class);
            BuildAddressEntity buildAddressEntity = mapper.map(projectUserRequest.getAddress(), BuildAddressEntity.class);

            buildAddressEntity.setAddress(projectUserRequest.getAddress());
            project.addAddress(buildAddressEntity);
            project.setProjectName(projectUserRequest.getProject());

            for(UserDTO name: projectUserRequest.getUsers()){

                RegistrationEntity registration = new RegistrationEntity();
                UserNameEntity user = mapper.map(name.getUser(), UserNameEntity.class);
                user.setName(name.getUser());
                for (String phoneNumberEntity : name.getPhones()){
                    PhoneNumberEntity phoneNumberData = mapper.map(phoneNumberEntity, PhoneNumberEntity.class);
                    phoneNumberData.setPhone(phoneNumberEntity);
                    user.addPhone(phoneNumberData);
                }
                registration.addBuildProject(user,project);
                userDataToSaveRepository.save(user);
                buildProjectSaveDataRepository.save(project);
                registrationRepository.save(registration);
            }
        }
    }
}
