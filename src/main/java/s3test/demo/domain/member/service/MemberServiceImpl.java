package s3test.demo.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s3test.demo.domain.member.dto.MemberInfoDto;
import s3test.demo.domain.member.dto.MemberSignUpDto;
import s3test.demo.domain.member.dto.MemberUpdateDto;
import s3test.demo.domain.member.entity.Member;
import s3test.demo.domain.member.exception.MemberException;

import s3test.demo.domain.member.repository.MemberRepository;

import static s3test.demo.domain.member.exception.MemberExceptionType.ALREADY_EXIST_USERNAME;
import static s3test.demo.domain.member.exception.MemberExceptionType.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Transactional
    @Override
    public Long signUp(MemberSignUpDto memberSignUpDto) {
        Member member = memberSignUpDto.toEntity();
        if(memberRepository.findByNickname(member.getNickname()).isPresent()) {
            throw new MemberException(ALREADY_EXIST_USERNAME);
        }
        Member save = memberRepository.save(member);
        return save.getId();

    }

    @Transactional
    @Override
    public void update(Long memberId, MemberUpdateDto memberUpdateDto){

        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberException(NOT_FOUND_MEMBER)
        );
        memberUpdateDto.nickname().ifPresent(member::updateNickname);
    }

    @Transactional
    @Override
    public void withdraw(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberException(NOT_FOUND_MEMBER)
        );
        memberRepository.delete(member);

    }

    @Override
    public MemberInfoDto getInfo(Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new MemberException(NOT_FOUND_MEMBER)
        );
        return MemberInfoDto.of(member);
    }


}
