package com.example.crrr.repository;

import com.example.crrr.model.Teacher;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @EntityGraph(value = "teacher-with-groups-and-course")
    @Query("SELECT t FROM Teacher t")
    List<Teacher> findAllWithGroupsAndCourse();
}
