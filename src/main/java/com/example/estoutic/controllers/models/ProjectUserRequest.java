package com.example.estoutic.controllers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProjectUserRequest {

    @JsonProperty("users")
    private ArrayList<UserDTO> users;

    @JsonProperty("project")
    private String project;

    @JsonProperty("address")
    public String address;
}
