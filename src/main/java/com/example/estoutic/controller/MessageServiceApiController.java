package com.example.estoutic.controller;
import com.example.estoutic.controller.models.BuildProjectSaveRequest;
import com.example.estoutic.controller.models.RegistrationRequest;
import com.example.estoutic.controller.models.UsernameSaveRequest;
import com.example.estoutic.database.models.BuildAddressEntity;
import com.example.estoutic.database.models.BuildProjectEntity;
import com.example.estoutic.database.models.PhoneNumberEntity;
import com.example.estoutic.database.models.UserNameEntity;
import com.example.estoutic.service.SaveDataService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class MessageServiceApiController {
    
    private UsernameSaveRequest usernameSaveRequest;
    private BuildProjectSaveRequest buildProjectSaveRequest;
    private RegistrationRequest registrationRequest;
//    private PhoneNumberSaveRequest phoneNumberSaveRequest;
    private final SaveDataService saveDataService;
    
    public MessageServiceApiController( SaveDataService saveDataService){
        this.saveDataService = saveDataService;
    }
    @PostMapping("/name")
    public String saveUserName(@RequestBody() UsernameSaveRequest usernameSaveRequest){
        this.usernameSaveRequest = usernameSaveRequest;
        return "saved username " + saveDataService.saveUserNameData(usernameSaveRequest);
    }

    @GetMapping("/name/{id}")
    public UserNameEntity geUserName(@PathVariable("id") String id) throws Exception {
        return saveDataService.getUserById(id);
    }
    @PostMapping("/project")
    public String saveBuildProject(@RequestBody() BuildProjectSaveRequest buildProjectSaveRequest){
        this.buildProjectSaveRequest = buildProjectSaveRequest;
        return "saved build project - " + saveDataService.saveBuildProjectData(buildProjectSaveRequest);
    }
//    @PostMapping("/phone")
//    public String savePhoneNumber(@RequestBody() PhoneNumberSaveRequest phoneNumberSaveRequest){
//        this.phoneNumberSaveRequest = phoneNumberSaveRequest;
//        return "saved phone number  - " + saveDataService.savePhoneNumberData(phoneNumberSaveRequest);
//    }
    @GetMapping("/project/{id}")
    public BuildProjectEntity getBuildProject(@PathVariable("id") String id) throws Exception {
        return saveDataService.getBuildProjectById(id);
    }
    @GetMapping("/phone/{id}")
    public PhoneNumberEntity getPhone(@PathVariable("id") String id) throws Exception {
        return saveDataService.getPhoneById(id);
    }
    @GetMapping("/address/{id}")
    public BuildAddressEntity getBuildAddress(@PathVariable("id") String id) throws Exception {
        return saveDataService.getBuildAddressById(id);
    }

    @PostMapping("/reg")
    public String registration(@RequestBody() RegistrationRequest registrationRequest){
        this.registrationRequest = registrationRequest;
        saveDataService.registrationUserProject(registrationRequest);
        return "saved build project ";
    }
}
