package s3test.demo.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import s3test.demo.domain.post.entity.Post;


import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String nickname;



    //== 회원탈퇴 -> 작성한 게시물 모두 삭제 ==//
    @Builder.Default
    @OneToMany(mappedBy = "writer", cascade = ALL, orphanRemoval = true)
    private List<Post> postList = new ArrayList<>();



    public void addPost(Post post){
        postList.add(post);
    }



    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }


}
