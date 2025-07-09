package s3test.demo.domain.post.service;

import s3test.demo.domain.post.dto.PostInfoDto;
import s3test.demo.domain.post.dto.PostSaveDto;
import s3test.demo.domain.post.dto.PostUpdateDto;

public interface PostService {
    /**
     * 새로운 게시글 저장
     * @param memberId 글 작성자 ID
     * @param dto      제목·내용·파일 정보
     * @return 저장된 Post 의 ID
     */
    Long savePost(Long memberId, PostSaveDto dto);

    /**
     * 단일 게시글 조회
     */
    PostInfoDto getPost(Long postId);

    /**
     * 게시글 수정 (필드 중 optional 값만 변경)
     */
    void updatePost(Long postId, PostUpdateDto dto);

    /**
     * 게시글 삭제
     */
    void deletePost(Long postId);
}