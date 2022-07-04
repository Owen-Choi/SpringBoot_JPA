package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // hello라는 이름의 html과 매핑된다.
    @GetMapping("hello")
    public String hello (Model model) {
        model.addAttribute("data", "hello!");
        // 사실상 hello.html 이 return 되는 것.
        return "hello";
    }
}
