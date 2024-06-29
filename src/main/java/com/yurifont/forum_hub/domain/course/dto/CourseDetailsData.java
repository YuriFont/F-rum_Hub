package com.yurifont.forum_hub.domain.course.dto;

import com.yurifont.forum_hub.domain.course.Category;
import com.yurifont.forum_hub.domain.course.Course;

public record CourseDetailsData(Long id, String name, Category category) {

    public CourseDetailsData(Course c) {
        this(c.getId(), c.getName(), c.getCategory());
    }

}
