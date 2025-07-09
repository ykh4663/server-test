package s3test.demo.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import s3test.demo.domain.member.entity.Member;

public record MemberSignUpDto(@NotBlank(message = "아이디를 입력해주세요") @Size(min = 1, max = 25, message = "아이디는 7~25자 내외로 입력해주세요")
                              String nickname) {
    public Member toEntity() {
        return Member.builder().nickname(nickname).build();
    }
}
