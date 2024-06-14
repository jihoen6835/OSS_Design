package ossDesign.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ossDesign.demo.entity.CourseProgress;

import java.util.List;

@Repository
public interface CourseProgressRepository extends JpaRepository<CourseProgress, Long> {

    @Query("SELECT cp FROM CourseProgress cp JOIN cp.courseGrade cg JOIN cg.course c WHERE c.name = :course AND cg.grade = :grade")
    List<CourseProgress> findByCourseAndGrade(@Param("course") String course, @Param("grade") int grade);
}
