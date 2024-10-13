package com.example.crrr.service;

import com.example.crrr.dto.TeacherDTO;
import com.example.crrr.mapper.TeacherMapper;
import com.example.crrr.model.Course;
import com.example.crrr.model.Group;
import com.example.crrr.model.Teacher;
import com.example.crrr.repository.CourseRepository;
import com.example.crrr.repository.GroupRepository;
import com.example.crrr.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {


    private TeacherRepository teacherRepository;

    private GroupRepository groupRepository;

    private CourseRepository courseRepository;

    public TeacherService(TeacherRepository teacherRepository, GroupRepository groupRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Course course = courseRepository.findById(teacherDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<Group> groups = groupRepository.findAllById(teacherDTO.getGroupIds());

        Teacher teacher = TeacherMapper.toEntity(teacherDTO, course, groups);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.toDTO(savedTeacher);
    }

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return TeacherMapper.toDTO(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
