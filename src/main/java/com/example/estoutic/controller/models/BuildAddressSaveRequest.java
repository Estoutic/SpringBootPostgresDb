package com.example.estoutic.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BuildAddressSaveRequest {

    @JsonProperty("address")
    public String address;

}
