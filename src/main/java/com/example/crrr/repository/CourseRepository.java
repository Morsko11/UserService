package com.example.crrr.repository;

import com.example.crrr.model.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @EntityGraph(value = "Course.groupsDetails", type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT c FROM Course c")
    Optional<Course> findWithGroupsById(Integer id);

    @EntityGraph(value = "Course.teachersDetails", type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT c FROM Course c")
    Optional<Course> findWithTeachersById(Integer id);
}
