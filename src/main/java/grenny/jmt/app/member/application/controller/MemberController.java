package grenny.jmt.app.member.application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import grenny.jmt.app.member.domain.Member;
import grenny.jmt.app.member.dto.MemberLoginDto;
import grenny.jmt.app.member.application.service.MemberService;
import grenny.jmt.app.member.dto.MemberJoinDto;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Mono<Member> join(@RequestBody MemberJoinDto memberJoinDto) {
        return memberService.join(memberJoinDto);
    }

    @PostMapping("/login")
    public void login(@RequestBody MemberLoginDto memberLoginDto) {
        memberService.login(memberLoginDto);
    }
}
