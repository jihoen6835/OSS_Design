package ossDesign.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "users")
public class UserEntity {

    // 인덱스 넘버
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    // 유저의 실명(아직 실명인증은없음)
    @NotBlank(message = "이름(실명)은 필수입력 입니다.")
    @Column(name = "user_name")
    private String user_name;

    // 유저의 아이디
    @NotBlank(message = "아이디는 필수입력 입니다.")
    @Column(name = "id")
    private String id;

    // 유저의 비밀번호
    @NotBlank(message = "비밀번호는 필수입력 입니다.")
    @Column(name = "password")
    private String password;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime created;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updated;

    @Column(length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'Active'")
    private String status = "Active";

    @PrePersist
    protected void onCreate() {
        if (created == null) {
            created = LocalDateTime.now();
        }
        if (updated == null) {
            updated = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }





}
