package s3test.demo.domain.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3test.demo.domain.member.dto.MemberInfoDto;
import s3test.demo.domain.member.dto.MemberSignUpDto;
import s3test.demo.domain.member.dto.MemberUpdateDto;
import s3test.demo.domain.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
@Tag(name = "Member", description = "회원 관리 API")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원 가입")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Valid @RequestBody MemberSignUpDto dto) {
        memberService.signUp(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "회원 정보 수정")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,
                       @Valid @RequestBody MemberUpdateDto dto) {
        memberService.update(id, dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "회원 조회", description = "ID로 회원 정보를 조회합니다.")
    @ResponseStatus(HttpStatus.OK)
    public MemberInfoDto getInfo(@PathVariable Long id) {
        return memberService.getInfo(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "회원 탈퇴")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withdraw(@PathVariable Long id) {
        memberService.withdraw(id);
    }
}