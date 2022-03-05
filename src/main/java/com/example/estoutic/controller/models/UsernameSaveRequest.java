package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UsernameSaveRequest {

    @JsonProperty("name")
    private String name;


    @JsonProperty("phones")
    private List<PhoneNumberSaveRequest> phones;

}
