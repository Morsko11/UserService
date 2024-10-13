package com.example.crrr.controller;

import com.example.crrr.BaseIT;
import com.example.crrr.dto.CourseDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest extends BaseIT {

    private WebClient webClient;

    @BeforeAll
    public void setUp(){
      webClient =  webClientBuilder.baseUrl("http://localhost:"+wirePortMock).build();
    }

    @Test
    void createCourse() {
        CourseDTO build = CourseDTO.builder().courseName("Python").description("test").build();


        CourseDTO block = webClient.post().uri("/api/courses").bodyValue(build).retrieve().bodyToMono(CourseDTO.class).block();
        assertNotNull(block);
    }
}