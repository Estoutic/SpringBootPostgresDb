package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BuildProjectSaveRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    public String address;

}
