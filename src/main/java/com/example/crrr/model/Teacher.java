package com.example.crrr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastname;
    private LocalDate age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "group_teacher", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groupTeachers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

}
