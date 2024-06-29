package com.yurifont.forum_hub.controllers;

import com.yurifont.forum_hub.domain.topic.dto.RegisterTopicData;
import com.yurifont.forum_hub.domain.topic.dto.TopicDetailsData;
import com.yurifont.forum_hub.domain.user.User;
import com.yurifont.forum_hub.domain.user.dto.RegisterUserData;
import com.yurifont.forum_hub.domain.user.dto.UserDetailsData;
import com.yurifont.forum_hub.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterUserData data, UriComponentsBuilder uriBuilder) {
        User user = new User(data);
        User userSave = userRepository.save(user);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailsData(userSave));
    }

}
