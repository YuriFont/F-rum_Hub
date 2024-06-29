package com.yurifont.forum_hub.controllers;

import com.yurifont.forum_hub.domain.course.Course;
import com.yurifont.forum_hub.domain.course.dto.CourseDetailsData;
import com.yurifont.forum_hub.domain.course.dto.RegisterCourseData;
import com.yurifont.forum_hub.domain.user.User;
import com.yurifont.forum_hub.domain.user.dto.RegisterUserData;
import com.yurifont.forum_hub.domain.user.dto.UserDetailsData;
import com.yurifont.forum_hub.repositories.CourseRepository;
import com.yurifont.forum_hub.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterCourseData data, UriComponentsBuilder uriBuilder) {
        Course course = new Course(data);
        Course courseSave = courseRepository.save(course);

        URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(uri).body(new CourseDetailsData(courseSave));
    }

}
