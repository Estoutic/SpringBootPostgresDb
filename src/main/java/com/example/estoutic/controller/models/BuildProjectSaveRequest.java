package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BuildProjectSaveRequest {

    @JsonProperty("project")
    private String name;

    @JsonProperty("address")
    public String address;

}
