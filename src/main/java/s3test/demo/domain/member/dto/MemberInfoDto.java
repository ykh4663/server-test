package s3test.demo.domain.member.dto;

import s3test.demo.domain.member.entity.Member;

public record MemberInfoDto(String nickName) {
    public static MemberInfoDto of(Member member){
        return new MemberInfoDto(member.getNickname());
    }
}
