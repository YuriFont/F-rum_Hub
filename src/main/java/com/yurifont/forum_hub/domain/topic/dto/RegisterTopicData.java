package com.yurifont.forum_hub.domain.topic.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegisterTopicData(@NotBlank String title, @NotBlank String message, @NotNull @Future LocalDateTime creationDate, @NotNull Long idUser, @NotNull Long idCourse) {
}
