package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsernameSaveRequest {

    @JsonProperty("name")
    private String name;

}
