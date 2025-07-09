package s3test.demo.domain.post.dto;

import lombok.Data;
import s3test.demo.domain.member.dto.MemberInfoDto;
import s3test.demo.domain.post.entity.Post;

@Data
public class PostInfoDto {
    private Long postId;
    private String title;
    private String content;
    private String filePath;

    private MemberInfoDto writerDto;

    public PostInfoDto(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.filePath = post.getImageUrl();
        this.writerDto = MemberInfoDto.of(post.getWriter());
    }

}
