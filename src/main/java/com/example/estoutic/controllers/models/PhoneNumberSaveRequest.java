package com.example.estoutic.controllers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhoneNumberSaveRequest {
    @JsonProperty("phone")
    private String phone;

}
