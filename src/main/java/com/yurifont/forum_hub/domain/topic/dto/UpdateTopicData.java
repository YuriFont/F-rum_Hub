package com.yurifont.forum_hub.domain.topic.dto;

import com.yurifont.forum_hub.domain.topic.Status;
import jakarta.validation.constraints.NotNull;

public record UpdateTopicData(@NotNull Long id, String title, String message, Status status) {
}
