package ossDesign.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "course_progress")
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_grade_id")
    private CourseGrade courseGrade;

    private String section;
    private String subSection;
    private boolean completed;

    // getters and setters
}
