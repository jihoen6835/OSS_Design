package ossDesign.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ossDesign.demo.domain.LoginForm;
import ossDesign.demo.entity.UserEntity;
import ossDesign.demo.service.LoginService;


@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @GetMapping("/login")
    public String loginForm(@ModelAttribute("LoginForm") LoginForm form, Model model) {
        model.addAttribute("form", form);
        return "login"; // "login.html"로 이동
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse httpServletResponse) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        UserEntity loginUser = loginService.login(form.getLoginId(), form.getPassword());

        if (loginUser == null) {
            bindingResult.reject("loginFail", "Invalid login ID or password.");
            return "login";
        }

        // 로그인 성공 시 쿠키 설정
        Cookie cookieCode = new Cookie("userId", String.valueOf(loginUser.getUserId()));
        httpServletResponse.addCookie(cookieCode);
        System.out.println("쿠키 정보 전달 완료: " + cookieCode);
        System.out.println("로그인 유저: " + loginUser.getUserId());
        return "redirect:/"; // 홈으로 리다이렉트
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
        return "redirect:/"; // 로그아웃 후 홈으로 리다이렉트
    }
}
