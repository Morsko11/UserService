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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups")
@Entity
@BatchSize(size = 10)  // Использование batch fetching для загрузки групп и связанных данных
@NamedEntityGraph(name = "group-with-clients-and-teachers", attributeNodes = {
        @NamedAttributeNode("clients"), @NamedAttributeNode("teachers") })
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)  // Lazy загрузка клиентов
    private List<Clients> clients;

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy загрузка курса
    private Course course;

    @ManyToMany(mappedBy = "groupTeachers", fetch = FetchType.LAZY)  // Lazy загрузка учителей
    private List<Teacher> teachers;

    // Getters и Setters
}
