package com.example.crrr.service;

import com.example.crrr.dto.CourseDTO;
import com.example.crrr.mapper.CourseMapper;
import com.example.crrr.model.Course;
import com.example.crrr.model.Group;
import com.example.crrr.repository.CourseRepository;
import com.example.crrr.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {


    private CourseRepository courseRepository;
    private GroupRepository groupRepository;

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

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseMapper.toDTO(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public void addGroupToCourse(Long groupId, Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (courseOptional.isPresent()) {
            if (groupOptional.isPresent()) {
                groupOptional.get().setCourse(courseOptional.get());
                groupRepository.save(groupOptional.get());
            }
        }
    }
}
