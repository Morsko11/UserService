package com.example.crrr.repository;

import com.example.crrr.model.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @EntityGraph(value = "course-with-teachers-and-groups")
    @Query("SELECT c FROM Course c")
    List<Course> findAllWithTeachersAndGroups();
}
