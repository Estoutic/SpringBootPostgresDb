package com.example.estoutic.controller;
import com.example.estoutic.controller.models.SaveRequest;
import com.example.estoutic.service.SaveDataService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class MessageServiceApiController {
    
    private SaveRequest saveRequest;
    private final SaveDataService saveDataService;
    
    public MessageServiceApiController( SaveDataService saveDataService){
        this.saveDataService = saveDataService;
    }
    @PostMapping("/save")
    public String save(@RequestBody() SaveRequest saveRequest){
        this.saveRequest = saveRequest;
        return "saved - " + saveDataService.saveData(saveRequest);
    }

    @GetMapping("/save")
    public SaveRequest getSave(){
        return saveRequest;
    }
}
