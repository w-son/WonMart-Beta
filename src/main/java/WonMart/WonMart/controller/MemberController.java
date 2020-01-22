package WonMart.WonMart.controller;

import WonMart.WonMart.domain.Address;
import WonMart.WonMart.domain.Member;
import WonMart.WonMart.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController { // 회원가입, 회원조회

    private final MemberService memberService;

    @PostMapping("/member/new")
    public String create(@Valid MemberForm form, BindingResult result, HttpSession session) {
        // @Valid : form에 빈 값이 들어가지 않게 해주는 annotation
        if(result.hasErrors()) {
            return "member/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet());
        Member member = new Member();
        member.setKakaoKey(session.getAttribute("kakaoKey").toString());
        member.setNickName(form.getNickName());
        member.setAddress(address);
        Long member_id = memberService.join(member);

        // 세션에 멤버의 id와 nickName 값 저장
        session.setAttribute("member_id", member_id);
        session.setAttribute("nickName", member.getNickName());

        return "redirect:/";
    }

    @GetMapping("/member")
    public String members(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "member/memberList";
    }

}
