package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // hello라는 이름의 html과 매핑된다.
    @GetMapping("hello")
    public String hello (Model model) {
        // 위에서 매핑된 hello를 템플릿에서 찾고, 거기에 있는 data에 "hello!"를 넣는다.
        model.addAttribute("data", "hello!");
        // 그리고 hello를 넣은 view를 반환한다.
        return "hello";
    }
}
