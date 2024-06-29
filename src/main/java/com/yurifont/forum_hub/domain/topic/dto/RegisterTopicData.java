package com.yurifont.forum_hub.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterTopicData(@NotBlank String title, @NotBlank String message, @NotNull Long idUser, @NotNull Long idCourse) {
}
