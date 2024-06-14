package ossDesign.demo.dto;

import lombok.Data;

@Data
public class ProgressUpdateRequest {

    private Long id;
    private boolean completed;

    // getters and setters
}