package com.dsl.controller;

import com.dsl.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestParam(name = "name") String name) {
        var result = service.findStudents(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/teachers")
    public ResponseEntity<?> getTeachers(@RequestParam(name = "name") String name) {
        var result = service.findTeachers(name);

        return ResponseEntity.ok(result);
    }
}
