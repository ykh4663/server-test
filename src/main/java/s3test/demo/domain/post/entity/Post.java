package s3test.demo.domain.post.entity;


import jakarta.persistence.*;
import lombok.*;
import s3test.demo.domain.member.entity.Member;
import s3test.demo.global.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = true)
    private String imageUrl;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;
    public void confirmWriter(Member writer) {
        //writer는 변경이 불가능하므로 이렇게만 해주어도 될듯
        this.writer = writer;
        writer.addPost(this);
    }
    public void updateTitle(String title) {
        this.title = title;
    }
    public void updateContent(String content) {
        this.content = content;
    }
    public void updateImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
