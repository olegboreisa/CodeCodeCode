package lt.boreisa.finalblog.Repository;

import lt.boreisa.finalblog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository <Comment, Long> {
}
