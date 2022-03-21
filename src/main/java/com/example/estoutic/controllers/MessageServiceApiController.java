package com.example.estoutic.controllers;
import com.example.estoutic.controllers.models.BuildProjectSaveRequest;
import com.example.estoutic.controllers.models.RegistrationRequest;
import com.example.estoutic.controllers.models.UsernameSaveRequest;
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
    private RegistrationRequest registrationRequest;
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

    @GetMapping("/phone/{id}")
    public PhoneNumberEntity getPhone(@PathVariable("id") String id) throws Exception {
        return saveDataService.getPhoneById(id);
    }

}
