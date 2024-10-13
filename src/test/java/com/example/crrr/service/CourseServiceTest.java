package com.example.crrr.service;

import com.example.crrr.BaseIT;
import com.example.crrr.model.Course;
import com.example.crrr.repository.CourseRepository;
import com.example.crrr.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class CourseServiceTest extends BaseIT {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    CourseService courseService;
    @Test
    void addGroupToCourseTest(){
        courseService.addGroupToCourse(2,1);
        Optional<Course> withGroupsById = courseRepository.findWithGroupsById(1);
        Optional<Course> withTeachersById = courseRepository.findWithTeachersById(1);
        assertEquals(2,withGroupsById.get().getGroups().size() );
        assertEquals(0,withTeachersById.get().getTeachers().size() );
        assertEquals(1,groupRepository.findById(2).get().getCourse().getId());
    }
}