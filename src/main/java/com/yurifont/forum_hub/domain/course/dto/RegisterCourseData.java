package com.yurifont.forum_hub.domain.course.dto;

import com.yurifont.forum_hub.domain.course.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterCourseData(@NotBlank String name, @NotNull Category category) {
}
