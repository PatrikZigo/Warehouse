package com.example.warehouse.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ResponseDTO {
    private String message;

    public ResponseDTO(String message){
        this.message = message;
    }


    public ResponseDTO(){}
}
