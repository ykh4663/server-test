package s3test.demo.domain.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import s3test.demo.domain.post.dto.PostInfoDto;
import s3test.demo.domain.post.dto.PostSaveDto;
import s3test.demo.domain.post.dto.PostUpdateDto;
import s3test.demo.domain.post.service.PostService;
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Tag(name = "Post", description = "게시글 관리 API")
public class PostController {

    private final PostService postService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "게시글 작성")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(
            @RequestParam Long memberId,
            @Valid @ModelAttribute PostSaveDto dto
    ) {
        postService.savePost(memberId, dto);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "게시글 조회")
    @ResponseStatus(HttpStatus.OK)
    public PostInfoDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @PutMapping(value = "/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "게시글 수정")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable Long postId,
            @Valid @ModelAttribute PostUpdateDto dto
    ) {
        postService.updatePost(postId, dto);
    }

    @DeleteMapping("/{postId}")
    @Operation(summary = "게시글 삭제")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}