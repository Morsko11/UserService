package com.example.crrr.repository;

import com.example.crrr.model.Group;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    @EntityGraph(value = "group-with-clients-and-teachers")
    @Query("SELECT g FROM Group g")
    List<Group> findAllWithClientsAndTeachers();

    List<Group> findAllByCourse_Id(int courseId);
}
