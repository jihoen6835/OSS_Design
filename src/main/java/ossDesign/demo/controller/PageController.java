package ossDesign.demo.controller;

import ch.qos.logback.core.model.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Getter @Setter
public class PageController {

    @RequestMapping("/")
    public String showHomePage() {
        return "home"; // home.html이 위치한 경로
    }

    @GetMapping("/signup") // GET 요청에 대한 처리
    public String showSignupPage() {
        return "signup"; // signup.html이 위치한 경로
    }

}

