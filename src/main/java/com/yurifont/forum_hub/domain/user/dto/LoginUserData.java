package com.yurifont.forum_hub.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginUserData(@NotBlank String name, @NotBlank String password) {
}
