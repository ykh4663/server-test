package s3test.demo.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import s3test.demo.adapter.aws.s3.S3Service;
import s3test.demo.domain.member.entity.Member;
import s3test.demo.domain.member.repository.MemberRepository;
import s3test.demo.domain.post.dto.PostInfoDto;
import s3test.demo.domain.post.dto.PostSaveDto;
import s3test.demo.domain.post.dto.PostUpdateDto;
import s3test.demo.domain.post.entity.Post;

import s3test.demo.domain.post.exception.PostException;
import s3test.demo.domain.post.repository.PostRepository;


import java.util.Optional;

import static s3test.demo.domain.post.exception.PostExceptionType.NOT_FOUND_POST;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final S3Service s3Service;

    @Override
    @Transactional
    public Long savePost(Long memberId, PostSaveDto dto) {
        // 1) 작성자 조회
        Member writer = memberRepository.findById(memberId)
                .orElseThrow(() -> new PostException(NOT_FOUND_POST));

        // 2) DTO → Entity (imageUrl 은 일단 null)
        Post post = dto.toEntity();

        // 3) 연관관계 세팅
        post.confirmWriter(writer);

        // 4) 파일 업로드가 있으면 S3에 올리고 URL set
        Optional<MultipartFile> maybeFile = dto.uploadFile();
        if (maybeFile.isPresent() && !maybeFile.get().isEmpty()) {
            String url = s3Service.uploadFile(maybeFile.get());
            post.updateImageUrl(url);
        }

        // 5) 저장
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public PostInfoDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(NOT_FOUND_POST));
        return new PostInfoDto(post);
    }

    @Override
    @Transactional
    public void updatePost(Long postId, PostUpdateDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(NOT_FOUND_POST));

        // 제목·내용 변경
        dto.title().ifPresent(post::updateTitle);
        dto.content().ifPresent(post::updateContent);

        // 파일 변경
        Optional<MultipartFile> maybeFile = dto.uploadFile();
        if (maybeFile.isPresent() && !maybeFile.get().isEmpty()) {
            String url = s3Service.uploadFile(maybeFile.get());
            post.updateImageUrl(url);
        }
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(NOT_FOUND_POST));
        postRepository.delete(post);
    }
}