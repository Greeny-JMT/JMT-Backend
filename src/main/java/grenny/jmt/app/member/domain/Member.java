package grenny.jmt.app.member.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import grenny.jmt.app.member.dto.MemberJoinDto;

@Document(collection = "member")
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    private String id;
    private String name;
    private String businessNo;
    private Date birthDay;

    public static Member create(MemberJoinDto dto) {
        return Member.builder()
            .id(UUID.randomUUID().toString())
            .name(dto.getName())
            .businessNo(dto.getBusinessNo())
            .birthDay(dto.getBirthDay())
            .build();
    }
}
