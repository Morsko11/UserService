package com.example.crrr.service;

import com.example.crrr.dto.CourseDTO;
import com.example.crrr.mapper.CourseMapper;
import com.example.crrr.model.Course;
import com.example.crrr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = CourseMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toDTO(savedCourse);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseMapper.toDTO(course);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
