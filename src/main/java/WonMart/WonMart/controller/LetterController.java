package WonMart.WonMart.controller;

import WonMart.WonMart.domain.Letter;
import WonMart.WonMart.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LetterController { // 쪽지 생성, 쪽지 조회

    private final LetterService letterService;

    @GetMapping("/letter/new")
    public String createLetter(Model model) {
        model.addAttribute("form", new LetterForm());
        return "letter/createLetterForm";
    }

    @PostMapping("/letter/new")
    public String create(LetterForm form, HttpSession session) {
        letterService.send((Long)session.getAttribute("member_id"), form.getReceiver(), form.getBody());

        return "redirect:/";
    }

    @GetMapping("/letter")
    public String letters(Model model) {
        List<Letter> letters = letterService.findLetters();
        model.addAttribute("letters", letters);

        return "letter/letterList";
    }

}
