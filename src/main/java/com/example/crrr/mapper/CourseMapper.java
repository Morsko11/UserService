package com.example.crrr.mapper;

import com.example.crrr.dto.CourseDTO;
import com.example.crrr.model.Course;

public class CourseMapper {
    public static CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        return dto;
    }

    public static Course toEntity(CourseDTO dto) {
        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        return course;
    }
}
