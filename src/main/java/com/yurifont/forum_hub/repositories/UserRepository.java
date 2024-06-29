package com.yurifont.forum_hub.repositories;

import com.yurifont.forum_hub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
