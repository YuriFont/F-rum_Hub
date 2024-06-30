package com.yurifont.forum_hub.repositories;

import com.yurifont.forum_hub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByName(String subject);
}
