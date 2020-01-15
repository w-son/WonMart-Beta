package WonMart.WonMart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /*
     RequestMapping : 화면 요청시
     GetMapping : 매핑되는 uri로 접근하는 경우 -> 다른 uri에서 model을 갖고 action을 취해 현재 uri로의 요청을 받아 전환되는 상황
     PostMapping : 매핑되는 uri에서 떠나는 경우 -> 현재 uri에서 model을 갖고 action을 취해서 다른 uri로 떠나는 상황
     */

    @RequestMapping("/")
    public String home() { return "home"; }

    /*
    @RequestMapping(value = "/login")
    public String login() { return "home"; }
    */

    // 실험용
    @GetMapping("test")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "test";
    }

}
