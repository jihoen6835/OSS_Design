package ossDesign.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ossDesign.demo.dto.ProgressUpdateRequest;
import ossDesign.demo.entity.CourseProgress;
import ossDesign.demo.service.ProgressService;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    @Autowired
    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/{course}/{grade}")
    public ResponseEntity<List<CourseProgress>> getProgressByCourseAndGrade(@PathVariable int course, @PathVariable int grade) {
        List<CourseProgress> progress = progressService.getProgressByCourseAndGrade(course, grade);
        return ResponseEntity.ok(progress);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateProgress(@RequestBody ProgressUpdateRequest request) {
        progressService.updateProgress(request);
        return ResponseEntity.ok().build();
    }

}
