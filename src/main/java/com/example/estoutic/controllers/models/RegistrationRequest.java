package com.example.estoutic.controllers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RegistrationRequest {

    @JsonProperty("projects")
    private ArrayList<ProjectUserRequest> projects;

}
