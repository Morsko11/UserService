package com.example.crrr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@BatchSize(size = 10)  // Использование batch fetching для загрузки курсов группами
@NamedEntityGraph(name = "Course.groupsDetails", attributeNodes = {
        @NamedAttributeNode("groups") })
@NamedEntityGraph(name = "Course.teachersDetails", attributeNodes = {
        @NamedAttributeNode("teachers") })
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String description;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Group> groups;


}

