package com.example.projectwithcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RequestResponse {
    private String status;
    private String message;
    private String messageDetail;
    private Object data;
}
