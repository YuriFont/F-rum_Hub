package com.yurifont.forum_hub.controllers;

import com.yurifont.forum_hub.domain.topic.Topic;
import com.yurifont.forum_hub.domain.topic.dto.RegisterTopicData;
import com.yurifont.forum_hub.domain.topic.dto.TopicDetailsData;
import com.yurifont.forum_hub.domain.topic.dto.UpdateTopicData;
import com.yurifont.forum_hub.repositories.TopicRepository;
import com.yurifont.forum_hub.service.TopicService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

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
                .map(t -> new TopicDetailsData(t.getId(), t.getTitle(), t.getUser().getId(), t.getCourse().getId(), t.getCreationDate()))
                .toList();
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDetailsData(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid UpdateTopicData data) {
        Optional<Topic> topic = topicRepository.findById(data.id());

        if (topic.isPresent())
            topic.get().update(data);
        return ResponseEntity.ok(new TopicDetailsData(topic.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        topic.ifPresent(value -> topicRepository.delete(value));

        return ResponseEntity.noContent().build();
    }

}
