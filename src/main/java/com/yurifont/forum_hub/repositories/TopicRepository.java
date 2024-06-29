package com.yurifont.forum_hub.repositories;

import com.yurifont.forum_hub.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
