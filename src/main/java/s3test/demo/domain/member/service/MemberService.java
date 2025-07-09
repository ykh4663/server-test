package s3test.demo.domain.member.service;

import s3test.demo.domain.member.dto.MemberInfoDto;
import s3test.demo.domain.member.dto.MemberSignUpDto;
import s3test.demo.domain.member.dto.MemberUpdateDto;

public interface MemberService {
    Long signUp(MemberSignUpDto memberSignUpDto);

    void update(Long memberId, MemberUpdateDto memberUpdateDto);

    void withdraw(Long memberId);

    MemberInfoDto getInfo(Long id);


}
