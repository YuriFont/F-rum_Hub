package com.yurifont.forum_hub.domain.course;


import com.yurifont.forum_hub.domain.course.dto.RegisterCourseData;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Category category;

    public Course(RegisterCourseData data) {
        this.name = data.name();
        this.category = data.category();
    }
}
