package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProjectUserRequest {

    @JsonProperty("users")
    private ArrayList<String> users;

    @JsonProperty("project")
    private String project;
}
