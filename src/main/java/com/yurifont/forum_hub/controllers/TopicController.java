package com.yurifont.forum_hub.controllers;

import com.yurifont.forum_hub.domain.topic.dto.RegisterTopicData;
import com.yurifont.forum_hub.domain.topic.dto.TopicDetailsData;
import com.yurifont.forum_hub.repositories.TopicRepository;
import com.yurifont.forum_hub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterTopicData data, UriComponentsBuilder uriBuilder) {
        TopicDetailsData topicDetailsData = topicService.register(data);
        return ResponseEntity.ok(topicDetailsData);
    }

}
