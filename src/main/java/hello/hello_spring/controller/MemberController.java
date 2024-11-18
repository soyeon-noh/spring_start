package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // spring container랑 연결시켜줌, 의존성 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // AOP 적용 후 의존관계
        // 프록시 증거
        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); // Memeber를 다 끄집어냄
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
