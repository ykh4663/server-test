package s3test.demo.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s3test.demo.domain.post.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
}
