package com.example.estoutic.controller;
import com.example.estoutic.controller.models.BuildProjectSaveRequest;
import com.example.estoutic.controller.models.UsernameSaveRequest;
import com.example.estoutic.database.models.UserNameSaveData;
import com.example.estoutic.service.SaveDataService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class MessageServiceApiController {
    
    private UsernameSaveRequest usernameSaveRequest;
    private BuildProjectSaveRequest buildProjectSaveRequest;
    private final SaveDataService saveDataService;
    
    public MessageServiceApiController( SaveDataService saveDataService){
        this.saveDataService = saveDataService;
    }
    @PostMapping("/name")
    public String saveUserName(@RequestBody() UsernameSaveRequest usernameSaveRequest){
        this.usernameSaveRequest = usernameSaveRequest;
        return "saved - " + saveDataService.saveUserNameData(usernameSaveRequest);
    }

    @GetMapping("/save/{id}")
    public UserNameSaveData geUserName(@PathVariable("id") String id) throws Exception {
        return saveDataService.getUserById(id);
    }
    @PostMapping("/project")
    public String saveBuildProject(@RequestBody() BuildProjectSaveRequest buildProjectSaveRequest){
        this.buildProjectSaveRequest = buildProjectSaveRequest;
        return "saved - " + saveDataService.saveBuildProjectData(buildProjectSaveRequest);
    }

}
