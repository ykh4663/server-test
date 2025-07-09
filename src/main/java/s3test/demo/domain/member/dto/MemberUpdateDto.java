package s3test.demo.domain.member.dto;

import java.util.Optional;

public record MemberUpdateDto(Optional<String> nickname) {
}
