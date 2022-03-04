package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class TelephoneNumberSaveRequest {
    @JsonProperty("telephone")
    private BigInteger telephone;

}
