package com.yurifont.forum_hub.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserData(@NotBlank String name, @NotBlank String email, @NotBlank String password) {
}
