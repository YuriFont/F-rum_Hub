package com.yurifont.forum_hub.repositories;

import com.yurifont.forum_hub.domain.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
