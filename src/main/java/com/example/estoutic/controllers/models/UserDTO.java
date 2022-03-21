package com.example.estoutic.controllers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UserDTO {

    @JsonProperty("phones")
    private ArrayList<String> phones;

    @JsonProperty("user")
    private String user;


}
