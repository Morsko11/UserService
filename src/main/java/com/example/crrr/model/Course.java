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
@NamedEntityGraph(name = "course-with-teachers-and-groups", attributeNodes = {
        @NamedAttributeNode("teachers"), @NamedAttributeNode("groups") })
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)  // Lazy загрузка учителей, связанных с курсом
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)  // Lazy загрузка групп, связанных с курсом
    private List<Group> groups;

    // Getters и Setters
}

