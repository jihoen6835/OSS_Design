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
    public String home(Model model) {
        return "signup";
    }


}

