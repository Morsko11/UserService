package com.example.crrr.mapper;

import com.example.crrr.dto.TeacherDTO;
import com.example.crrr.model.Course;
import com.example.crrr.model.Group;
import com.example.crrr.model.Teacher;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherMapper {
    public static TeacherDTO toDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setLastname(teacher.getLastname());
        dto.setAge(teacher.getAge());
        dto.setCourseId(teacher.getCourse().getId());
        dto.setGroupIds(teacher.getGroupTeachers().stream()
                .map(Group::getId).collect(Collectors.toList()));
        return dto;
    }

    public static Teacher toEntity(TeacherDTO dto, Course course, List<Group> groups) {
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setLastname(dto.getLastname());
        teacher.setAge(dto.getAge());
        teacher.setCourse(course);
        teacher.setGroupTeachers(groups);
        return teacher;
    }
}
