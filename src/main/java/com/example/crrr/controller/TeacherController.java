package com.example.crrr.controller;

import com.example.crrr.dto.TeacherDTO;
import com.example.crrr.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        return new ResponseEntity<>(teacherService.createTeacher(teacherDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Integer id) {
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
