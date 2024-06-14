package ossDesign.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ossDesign.demo.entity.UserEntity;
import ossDesign.demo.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    // 회원가입 api
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody UserEntity userEntity,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("유효하지 않은 사용자 데이터가 전송되었습니다: {}", bindingResult.getAllErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"사용할 수 없는 유저 데이터\"}");
        }
        try {
            UserEntity savedUser = userService.signUp(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"회원가입에 성공하였습니다! 환영합니다 " + savedUser.getUserName() + "님!!\"}");
        } catch (IllegalStateException e) {
            logger.error("회원가입 중 오류 발생: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"" + e.getMessage() + "\"}");
        }
    }


}
