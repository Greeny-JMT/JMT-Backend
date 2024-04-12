package grenny.jmt.app.member.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinDto {
    private String name;
    private String businessNo;
    private Date birthDay;
}
