package com.example.crrr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private int id;
    private String name;
    private String lastname;
    private LocalDate age;
    private List<Integer> groupIds;
    private int courseId;

}
