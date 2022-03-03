package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TelephoneNumberSaveRequest {
    @JsonProperty("telephone")
    private Long telephone;

}
