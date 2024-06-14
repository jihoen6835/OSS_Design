package ossDesign.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import ossDesign.demo.dto.ProgressUpdateRequest;
import ossDesign.demo.entity.CourseProgress;
import ossDesign.demo.repository.CourseProgressRepository;

import java.util.List;


@Service
public class ProgressService {

    private final CourseProgressRepository courseProgressRepository;



    @Autowired
    public ProgressService(CourseProgressRepository courseProgressRepository) {
        this.courseProgressRepository = courseProgressRepository;
    }

    public List<CourseProgress> getProgressByCourseAndGrade(int course, int grade) {
        return courseProgressRepository.findByCourseAndGrade(String.valueOf(course), grade);
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    public void updateProgress(ProgressUpdateRequest request) {
        CourseProgress progress = courseProgressRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Progress not found"));
        progress.setCompleted(request.isCompleted());
        courseProgressRepository.save(progress);
    }

}
