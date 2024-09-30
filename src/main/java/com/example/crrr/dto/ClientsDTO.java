package com.example.crrr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDTO {
    private Integer id;
    private String name;
    private String lastname;
    private LocalDate dob;
    private Integer groupId;

}
