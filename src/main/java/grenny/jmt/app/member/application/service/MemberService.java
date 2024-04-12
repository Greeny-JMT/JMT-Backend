package grenny.jmt.app.member.application.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import grenny.jmt.app.member.dto.MemberLoginDto;
import grenny.jmt.app.member.repository.MemberRepository;
import grenny.jmt.app.member.domain.Member;
import grenny.jmt.app.member.dto.MemberJoinDto;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Mono<Member> join(MemberJoinDto memberJoinDto) {
        return memberRepository.findByBusinessNo(memberJoinDto.getBusinessNo())
            .flatMap(member -> {
                if (member == null) {
                    return memberRepository.save(Member.create(memberJoinDto));
                }
                return Mono.error(RuntimeException::new);
            });
    }

    public void login(MemberLoginDto memberLoginDto) {
        memberRepository.findByBusinessNo(memberLoginDto.getBusinessNo());
    }
}
