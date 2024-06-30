package com.yurifont.forum_hub.controllers;

import com.yurifont.forum_hub.domain.topic.Topic;
import com.yurifont.forum_hub.domain.topic.dto.RegisterTopicData;
import com.yurifont.forum_hub.domain.topic.dto.TopicDetailsData;
import com.yurifont.forum_hub.repositories.TopicRepository;
import com.yurifont.forum_hub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TopicDetailsData>> list() {
        List<Topic> list = topicRepository.findAll();
        List<TopicDetailsData> listDTO = list.stream()
                .map(t -> new TopicDetailsData(t.getId(), t.getUser().getId(), t.getCourse().getId(), t.getCreationDate()))
                .toList();
        return ResponseEntity.ok(listDTO);
    }

}
