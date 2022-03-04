package com.example.estoutic.controller;
import com.example.estoutic.controller.models.BuildAddressSaveRequest;
import com.example.estoutic.controller.models.BuildProjectSaveRequest;
import com.example.estoutic.controller.models.TelephoneNumberSaveRequest;
import com.example.estoutic.controller.models.UsernameSaveRequest;
import com.example.estoutic.database.models.BuildAddressSaveData;
import com.example.estoutic.database.models.BuildProjectSaveData;
import com.example.estoutic.database.models.PhoneNumberSaveData;
import com.example.estoutic.database.models.UserNameSaveData;
import com.example.estoutic.service.SaveDataService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class MessageServiceApiController {
    
    private UsernameSaveRequest usernameSaveRequest;
    private BuildProjectSaveRequest buildProjectSaveRequest;
    private TelephoneNumberSaveRequest telephoneNumberSaveRequest;
    private BuildAddressSaveRequest buildAddressSaveRequest;
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
    public UserNameSaveData geUserName(@PathVariable("id") String id) throws Exception {
        return saveDataService.getUserById(id);
    }
    @PostMapping("/project")
    public String saveBuildProject(@RequestBody() BuildProjectSaveRequest buildProjectSaveRequest){
        this.buildProjectSaveRequest = buildProjectSaveRequest;
        return "saved build project - " + saveDataService.saveBuildProjectData(buildProjectSaveRequest);
    }
    @PostMapping("/phone")
    public String savePhoneNumber(@RequestBody() TelephoneNumberSaveRequest telephoneNumberSaveRequest){
        this.telephoneNumberSaveRequest = telephoneNumberSaveRequest;
        return "saved phone number  - " + saveDataService.savePhoneNumberData(telephoneNumberSaveRequest);
    }
    @GetMapping("/project/{id}")
    public BuildProjectSaveData getBuildProject(@PathVariable("id") String id) throws Exception {
        return saveDataService.getBuildProjectById(id);
    }
    @GetMapping("/phone/{id}")
    public PhoneNumberSaveData getPhone(@PathVariable("id") String id) throws Exception {
        return saveDataService.getPhoneById(id);
    }
    @PostMapping("/address")
    public String saveBuildAddress(@RequestBody() BuildAddressSaveRequest buildAddressSaveRequest){
        this.buildAddressSaveRequest = buildAddressSaveRequest;
        return "saved build address" + saveDataService.saveBuildAddressData(buildAddressSaveRequest);
    }
    @GetMapping("/address/{id}")
    public BuildAddressSaveData getBuildAddress(@PathVariable("id") String id) throws Exception {
        return saveDataService.getBuildAddressById(id);
    }
}
