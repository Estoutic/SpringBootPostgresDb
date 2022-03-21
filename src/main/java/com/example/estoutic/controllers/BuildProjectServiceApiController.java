package com.example.estoutic.controllers;

import com.example.estoutic.controllers.models.RegistrationRequest;
import com.example.estoutic.database.models.BuildProjectEntity;
import com.example.estoutic.service.BuildProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/build")
public class BuildProjectServiceApiController {

    private final BuildProjectService buildProjectService;
    private RegistrationRequest registrationRequest;

    public BuildProjectServiceApiController(BuildProjectService buildProjectService){
        this.buildProjectService = buildProjectService;
    }

    @GetMapping("/project/{id}")
    public BuildProjectEntity getBuildProject(@PathVariable("id") String id) throws Exception {
        return buildProjectService.getBuildProjectById(id);
    }

    @PostMapping("/reg")
    public String registration(@RequestBody() RegistrationRequest registrationRequest){
        this.registrationRequest = registrationRequest;
        buildProjectService.registrationUserProject(registrationRequest);
        return "saved build project ";
    }
}
