package grenny.jmt.app.member.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import grenny.jmt.app.member.application.service.MemberService;
import grenny.jmt.app.member.dto.MemberJoinDto;
import grenny.jmt.app.member.dto.MemberLoginDto;
import grenny.jmt.app.member.dto.MemberResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Mono<MemberResponseDto> join(@RequestBody MemberJoinDto memberJoinDto) {
        return memberService.join(memberJoinDto)
            .map(m -> MemberResponseDto.builder()
                .name(m.getName())
                .businessNo(m.getBusinessNo())
                .birthDay(m.getBirthDay())
                .build());
    }

    @PostMapping("/login")
    public void login(@RequestBody MemberLoginDto memberLoginDto) {
        memberService.login(memberLoginDto);
    }

    @GetMapping("/members")
    public Flux<MemberResponseDto> getAllMember() {
        return memberService.findAllMembers()
            .map(m -> MemberResponseDto.builder()
                .name(m.getName())
                .businessNo(m.getBusinessNo())
                .birthDay(m.getBirthDay())
                .build());
    }

    @GetMapping("/member/{businessNo}")
    public Mono<MemberResponseDto> getMemberByBusinessNo(@PathVariable String businessNo) {
        return memberService.findMemberById(businessNo)
            .map(m -> MemberResponseDto.builder()
                .name(m.getName())
                .businessNo(m.getBusinessNo())
                .birthDay(m.getBirthDay())
                .build());
    }
}
