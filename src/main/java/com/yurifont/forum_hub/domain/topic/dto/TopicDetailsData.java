package com.yurifont.forum_hub.domain.topic.dto;

import com.yurifont.forum_hub.domain.topic.Topic;

import java.time.LocalDateTime;

public record TopicDetailsData(Long id, Long idUser, Long idCourse, LocalDateTime date) {

    public TopicDetailsData(Topic t) {
        this(t.getId(), t.getUser().getId(), t.getCourse().getId(), t.getCreationDate());
    }

}
