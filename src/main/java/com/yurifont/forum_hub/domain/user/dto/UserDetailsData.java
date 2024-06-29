package com.yurifont.forum_hub.domain.user.dto;

import com.yurifont.forum_hub.domain.user.User;

public record UserDetailsData(Long id, String name, String password) {

    public UserDetailsData(User user) {
        this(user.getId(), user.getName(), user.getPassword());
    }

}
