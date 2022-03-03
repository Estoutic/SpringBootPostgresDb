package com.example.estoutic.controller;
import com.example.estoutic.controller.models.SaveRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class MessageServiceApiController {
    private SaveRequest saveRequest;

    @PostMapping("/save")
    public String save(@RequestBody() SaveRequest saveRequest){
        this.saveRequest = saveRequest;
        return "saved - ";
    }

    @GetMapping("/save")
    public SaveRequest getSave(){
        return saveRequest;
    }
}
