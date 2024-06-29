package com.yurifont.forum_hub.repositories;

import com.yurifont.forum_hub.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
