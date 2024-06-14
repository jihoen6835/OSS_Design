package ossDesign.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import ossDesign.demo.entity.UserEntity;
import ossDesign.demo.repository.UserRepository;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String home(@CookieValue(name = "userId", required = false) Long userId, Model model) {
        if (userId == null) {
            return "redirect:/login"; // 로그인 필요 시 로그인 페이지로 리다이렉트
        }

        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return "redirect:/login"; // 사용자가 없는 경우 로그인 페이지로 리다이렉트
        }

        model.addAttribute("user", userOptional.get());
        return "main"; // 로그인 성공 시 메인 페이지로 이동
    }


    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }
    @GetMapping("/calender")
    public String calender(Model model) {
        return "calender";
    }
    @GetMapping("/note")
    public String note(Model model) {
        return "note";
    }
    @GetMapping("/checkProc")
    public String checkProc(Model model) {
        return "checkProc";
    }


}
