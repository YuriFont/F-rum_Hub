package com.yurifont.forum_hub.service;

import com.yurifont.forum_hub.domain.course.Course;
import com.yurifont.forum_hub.domain.topic.Topic;
import com.yurifont.forum_hub.domain.topic.dto.RegisterTopicData;
import com.yurifont.forum_hub.domain.topic.dto.TopicDetailsData;
import com.yurifont.forum_hub.domain.user.User;
import com.yurifont.forum_hub.infra.exceptions.ValidationException;
import com.yurifont.forum_hub.repositories.CourseRepository;
import com.yurifont.forum_hub.repositories.TopicRepository;
import com.yurifont.forum_hub.repositories.UserRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    public TopicDetailsData register(RegisterTopicData data) {
        if (!userRepository.existsById(data.idUser())) {
            throw new ValidationException("Id do usuário informado não existe!!!");
        }
        if (!courseRepository.existsById(data.idCourse())) {
            throw new ValidationException("Id do curso informado não existe!!!");
        }

        User user = userRepository.getReferenceById(data.idUser());
        Course course = courseRepository.getReferenceById(data.idCourse());
        Topic topic = new Topic(data.title(), data.message(), data.creationDate(), user, course);

        Topic topicSave = topicRepository.save(topic);

        return new TopicDetailsData(topicSave.getId(), topicSave.getUser().getId(), topicSave.getCourse().getId(), topicSave.getCreationDate());
    }
}
