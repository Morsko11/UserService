package com.example.crrr.service;

import com.example.crrr.BaseIT;
import com.example.crrr.repository.CourseRepository;
import com.example.crrr.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        assertEquals(2,courseRepository.findById(1).get().getGroups().size() );
        assertEquals(1,groupRepository.findById(2).get().getCourse().getId());
    }
}