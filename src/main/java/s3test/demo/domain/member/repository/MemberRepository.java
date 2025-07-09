package s3test.demo.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s3test.demo.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {



    Optional<Member> findByNickname(String nickname);
}
